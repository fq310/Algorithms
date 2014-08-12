package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeTwoSortedListsTest {

	@Test
	public void test() {
		MergeTwoSortedLists m = new MergeTwoSortedLists();
		assertEquals(m.mergeTwoLists(null, null), null);
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		assertEquals(m.mergeTwoLists(l1, l2).toString(), "1");
	}

}
