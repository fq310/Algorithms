package leetcode;

import static org.junit.Assert.*;
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
