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

	//2.4
	public Node<Integer> partition(Node<Integer> list, Integer i) {
		if (list == null) return null;
		Node<Integer> node = list;
		Node<Integer> smaller = new Node<Integer>();
		Node<Integer> bigger = new Node<Integer>();
		Node<Integer> biggerHead = bigger;
		Node<Integer> smallerHead = smaller;
		while (node != null) {
			if (node.value >= i) {
				bigger.next = new Node<Integer>();
				bigger = bigger.next;
				bigger.value = node.value;
			} else {
				smaller.next = new Node<Integer>();
				smaller = smaller.next;
				smaller.value = node.value;
			}
			node = node.next;
		}
		smaller.next = biggerHead.next;
		return smallerHead.next;
	}

	public Node<Integer> add(Node<Integer> list1, Node<Integer> list2) {
		Node<Integer> result = new Node<>();
		result.value = 0;
		Node<Integer> node = result;
		while (list1 != null && list2 != null) {
			int sum = list1.value + list2.value + node.value;
			node = createSumNode(node, sum);
			list1 = list1.next;
			list2 = list2.next;
		}
		while (list1 != null) {
			int sum = list1.value + node.value;
			node = createSumNode(node, sum);
			list1 = list1.next;
		}
		while (list2 != null) {
			int sum = list2.value + node.value;
			node = createSumNode(node, sum);
			list2 = list2.next;
		}
		Node<Integer> n = result;
		while (n != null && n.next != node) {
			n = n.next;
		}
		n.next = null;
		return result;
	}

	private Node<Integer> createSumNode(Node<Integer> node, int sum) {
		if (sum > 9) {
			node.value = sum % 10;
			node.next = new Node<>();
			node = node.next;
			node.value = 1;
		} else {
			node.value = sum;
			node.next = new Node<>();
			node = node.next;
			node.value = 0;
		}
		return node;
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
