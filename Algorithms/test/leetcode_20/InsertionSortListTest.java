package leetcode_20;

import static org.junit.Assert.*;
import leetcode.util.ListUtil;
import leetcode_30.ListNode;

import org.junit.Test;

public class InsertionSortListTest {

	@Test
	public void test() {
		test(new int[]{1}, new int[]{1});
		test(new int[]{1, 2}, new int[]{1, 2});
		test(new int[]{2, 1}, new int[]{1, 2});
		test(new int[]{1, 2, 3}, new int[]{1, 2, 3});
		test(new int[]{2, 3, 1}, new int[]{1, 2, 3});
		test(new int[]{3, 2, 1}, new int[]{1, 2, 3});
		test(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
		test(new int[]{2, 3, 1, 4}, new int[]{1, 2, 3, 4});
		test(new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 4});
	}

	private void test(int[] before, int[] after) {
		InsertionSortList i = new InsertionSortList();
		ListNode sorted = i.insertionSortList(ListUtil.createList(before));
		assertArrayEquals(ListUtil.getArrayFrom(sorted), after);
	}

}
