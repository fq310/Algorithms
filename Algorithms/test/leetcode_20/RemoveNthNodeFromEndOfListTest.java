package leetcode_20;

import static org.junit.Assert.*;
import leetcode.util.ListUtil;

import org.junit.Test;

public class RemoveNthNodeFromEndOfListTest {

	@Test
	public void test() {
		RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
		assertEquals(r.removeNthFromEnd(ListUtil.createList(new int[]{1}), 1), null);
		assertEquals(r.removeNthFromEnd(ListUtil.createList(new int[]{1, 2}), 2).toString(), "2");
		assertEquals(r.removeNthFromEnd(ListUtil.createList(new int[]{1,2,3,4,5}), 2).toString(), "1");
	}

}
