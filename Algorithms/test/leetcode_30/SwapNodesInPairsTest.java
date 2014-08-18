package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class SwapNodesInPairsTest {

	@Test
	public void test() {
		SwapNodesInPairs s = new SwapNodesInPairs();
		ListNode head = createList(new int[]{1, 2, 3, 4});
		assertEquals(s.swapPairs(head).toString(), "2");
	}

	private ListNode createList(int[] data) {
		ListNode head = new ListNode(0);
		ListNode node = head;
		for (int i : data) {
			node.next = new ListNode(i);
			node = node.next;
		}
		return head.next;
	}

}
