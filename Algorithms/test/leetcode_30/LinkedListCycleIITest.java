package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.LinkedListCycleII;
import leetcode_30.ListNode;

import org.junit.Test;

public class LinkedListCycleIITest {

	@Test
	public void test() {
		LinkedListCycleII ll = new LinkedListCycleII();
		ListNode h = new ListNode(1);
		h.next = h;
		assertEquals(ll.detectCycle(h), h);
		
		h.next = new ListNode(1);
		h.next.next = h;
		assertEquals(ll.detectCycle(h), h);
	}

}
