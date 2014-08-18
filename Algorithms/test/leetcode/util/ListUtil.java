package leetcode.util;

import leetcode_30.ListNode;

public class ListUtil {
	public static ListNode createList(int[] data) {
		ListNode head = new ListNode(0);
		ListNode node = head;
		for (int i : data) {
			node.next = new ListNode(i);
			node = node.next;
		}
		return head.next;
	}
}
