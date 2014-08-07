package leetcode_30;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RemoveDuplicatesFromSortedListIITest {

	@Test
	public void test() {
		test(new int[]{1,1,2,3,3}, "[2]");
		test(new int[]{1,2,3,3,4,4,5}, "[1, 2, 5]");
	}

	private void test(int[] data, String target) {
		ListNode head = new ListNode(data[0]);
		ListNode node = head;
		for (int i = 1; i < data.length; ++i) {
			node.next = new ListNode(data[i]);
			node = node.next;
		}
		RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
		ListNode newHead =  r.deleteDuplicates(head);
		List<Integer> result = new ArrayList<>();
		while (newHead != null) {
			result.add(newHead.val);
			newHead = newHead.next;
		}
		assertEquals(result.toString(), target);
	}

}
