package leetcode_20;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private int capacity;
	private int currentSize = 0;
	private Map<Integer, Node> keyNodeMap = new HashMap<>();
	private Node head = new Node(-1, -1), tail = new Node(-1, -1);
	
	class Node {
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
		int key;
		int value;
		Node next;
		Node pre;
		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + "]";
		}
	}
    public LRUCache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.pre = head;
    }
    
    public int get(int key) {
    	Node node = keyNodeMap.get(key);
    	if (node == null) return -1;
    	remove(key);
		addToHead(key, node.value);
        return node.value;
    }
    
    public void set(int key, int value) {
    	if (keyNodeMap.containsKey(key)) {
			remove(key);
			addToHead(key, value);
    	} else {
        	if (currentSize < capacity) {
    			++currentSize;
    			addToHead(key, value);
        	} else {
    			int tailKey = removeTail();
    			keyNodeMap.remove(tailKey);
    			addToHead(key, value);
        	}
    	}
    }

	private void remove(int key) {
		Node node = keyNodeMap.get(key);
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	private void addToHead(int key, int value) {
		Node node = new Node(key, value);
		head.next.pre = node;
		node.next = head.next;
		node.pre = head;
		head.next = node;
		keyNodeMap.put(key, node);
	}

	private int removeTail() {
		Node node = tail.pre;
		node.pre.next = tail;
		tail.pre = node.pre;
		return node.key;
	}
}
