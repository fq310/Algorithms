package leetcode.util;

import java.util.ArrayList;
import java.util.List;

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
	
	public static int[] getArrayFrom(ListNode head) {
		List<Integer> nodes = new ArrayList<>();
		while (head != null) {
			nodes.add(head.val);
			head = head.next;
		}
		int[] array = new int[nodes.size()];
		for (int i = 0; i < nodes.size(); ++i) {
			array[i] = nodes.get(i);
		}
		return array;
	}
}
