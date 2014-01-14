package cci;

import java.util.HashSet;

public class Chapter2<T> {
	//2.1
	public void removeDuplicate(Node<T> head) {
		HashSet<Node<T>> nodeSet = new HashSet<Node<T>>();
		if (head == null) return;
		nodeSet.add(head);
		Node<T> pre = head;
		Node<T> node = pre.next;
		while (node != null) {
			if (nodeSet.contains(node)) {
				pre.next = node.next;
			} else {
				nodeSet.add(node);
				pre = pre.next;
			}
			if (pre != null) {
				node = pre.next;
			}
		}
	}
	
	//2.2
	public Node<T> findElement(Node<T> list, int k) {
		Node<T> node = list;
		while (k > 1 && node != null) {
			node = node.next;
			--k;
		}
		if (node == null) return null;
		Node<T> pre = list;
		while (node.next != null) {
			node = node.next;
			pre = pre.next;
		}
		return pre;
	}

	//2.3
	public void deleteTarget(Node<Integer> node) {
		if (node == null || node.next == null) return;
		Node<Integer> next = node.next;
		node.value = next.value;
		node.next = next.next;
	}

	public void partition(Node<T> list, T i) {
		
	}
	
	
}

class Node<T> {
	public T value;
	public Node<T> next;
	
	public void addToTail(T value) {
		Node<T> node = this;
		while (node.next != null) {
			node = node.next;
		}
		node.next = new Node<T>();
		node.next.value = value;
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj.getClass() != this.getClass()) return false;
		Node<?> that = (Node<?>) obj;
		return that.value.equals(value);
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}
