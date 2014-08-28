package leetcode_20;

import static org.junit.Assert.*;
import leetcode.util.ListUtil;
import leetcode_30.ListNode;

import org.junit.Test;

public class RotateListTest {

	@Test
	public void test() {
		RotateList r = new RotateList();
		ListNode oldList = ListUtil.createList(new int[]{1, 2, 3, 4, 5});
		assertEquals(r.rotateRight(oldList, 2).toString(), "4");
		oldList = ListUtil.createList(new int[]{1});
		assertEquals(r.rotateRight(oldList, 1).toString(), "1");
		oldList = ListUtil.createList(new int[]{1, 2});
		assertEquals(r.rotateRight(oldList, 2).toString(), "1");
		oldList = ListUtil.createList(new int[]{1, 2});
		assertEquals(r.rotateRight(oldList, 1).toString(), "2");
	}

}
