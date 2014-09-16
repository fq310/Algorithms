package leetcode_20;

import static org.junit.Assert.*;
import leetcode.util.ListUtil;
import leetcode_30.ListNode;

import org.junit.Test;

public class ReorderListTest {

	@Test
	public void test() {
		test(new int[]{0}, new int[]{0});
		test(new int[]{0, 1}, new int[]{0, 1});
		test(new int[]{1, 2, 3}, new int[]{1, 3, 2});
		test(new int[]{1, 2, 3, 4}, new int[]{1, 4, 2, 3});
		test(new int[]{1, 2, 3, 4, 5}, new int[]{1, 5, 2, 4, 3});
	}

	private void test(int[] before, int[] after) {
		ReorderList r = new ReorderList();
		ListNode n = ListUtil.createList(before);
		r.reorderList(n);
		assertArrayEquals(ListUtil.getArrayFrom(n), after);
	}

}
