package leetcode_20;

import leetcode_30.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
    	if (head == null) return null;
    	int length = getLength(head);
    	n = n % length;
    	if (n == 0) return head;
    	ListNode newTailNode = getNewTailNode(head, n, length);
    	ListNode newHead = newTailNode.next;
    	modifyOldTail(head, newTailNode);
    	newTailNode.next = null;
        return newHead;
    }

	private void modifyOldTail(ListNode head, ListNode newTailNode) {
		ListNode oldTail = newTailNode;
    	while (oldTail.next != null) {
    		oldTail = oldTail.next;
    	}
    	oldTail.next = head;
	}

	private ListNode getNewTailNode(ListNode head, int n, int length) {
		ListNode node = head;
    	int tailIndex = length - n;
    	int index = 1;
    	while (index != tailIndex && node != null) {
    		node = node.next;
    		++index;
    	}
		return node;
	}

	private int getLength(ListNode node) {
		int length = 0;
    	while (node != null) {
    		++length;
    		node = node.next;
    	}
		return length;
	}
}
