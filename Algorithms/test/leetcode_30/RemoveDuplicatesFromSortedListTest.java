package leetcode_30;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RemoveDuplicatesFromSortedListTest {

	@Test
	public void test() {
		test(new int[]{1,1,2,3,3}, "[1, 2, 3]");
	}

	private void test(int[] data, String target) {
		ListNode head = new ListNode(data[0]);
		ListNode node = head;
		for (int i = 1; i < data.length; ++i) {
			node.next = new ListNode(data[i]);
			node = node.next;
		}
		RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
		r.deleteDuplicates(head);
		List<Integer> result = new ArrayList<>();
		while (head != null) {
			result.add(head.val);
			head = head.next;
		}
		assertEquals(result.toString(), target);
	}

}
