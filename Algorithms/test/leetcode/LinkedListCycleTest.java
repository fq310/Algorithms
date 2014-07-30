package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListCycleTest {

	@Test
	public void test() {
		LinkedListCycle l = new LinkedListCycle();
		ListNode head = new ListNode(1);
		head.next = head;
		assertEquals(l.hasCycle(head), true);
		head.next = new ListNode(1);
		head.next.next = head;
		assertEquals(l.hasCycle(head), true);
		assertEquals(l.hasCycle(null), false);
		head.next.next = null;
		assertEquals(l.hasCycle(head), false);
		
		
	}

}
