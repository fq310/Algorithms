package leetcode_20;

import static org.junit.Assert.*;
import leetcode.util.ListUtil;
import leetcode_30.ListNode;

import org.junit.Test;

public class ReverseLinkedListIITest {

	@Test
	public void test() {
		ReverseLinkedListII r = new ReverseLinkedListII();
		ListNode list1 = ListUtil.createList(new int[]{1});
		ListNode list2 = ListUtil.createList(new int[]{1, 2});
		ListNode list3 = ListUtil.createList(new int[]{1, 2, 3});
		assertArrayEquals(ListUtil.getArrayFrom(r.reverseBetween(list1, 1, 1)), new int[]{1});
		assertArrayEquals(ListUtil.getArrayFrom(r.reverseBetween(list2, 1, 1)), new int[]{1, 2});
		assertArrayEquals(ListUtil.getArrayFrom(r.reverseBetween(list2, 2, 2)), new int[]{1, 2});
		assertArrayEquals(ListUtil.getArrayFrom(r.reverseBetween(list2, 1, 2)), new int[]{2, 1});
		assertArrayEquals(ListUtil.getArrayFrom(r.reverseBetween(list3, 1, 1)), new int[]{1, 2, 3});
		assertArrayEquals(ListUtil.getArrayFrom(r.reverseBetween(list3, 2, 2)), new int[]{1, 2, 3});
		assertArrayEquals(ListUtil.getArrayFrom(r.reverseBetween(list3, 3, 3)), new int[]{1, 2, 3});
		assertArrayEquals(ListUtil.getArrayFrom(r.reverseBetween(ListUtil.createList(new int[]{1, 2, 3}), 1, 2)), new int[]{2, 1, 3});
		assertArrayEquals(ListUtil.getArrayFrom(r.reverseBetween(ListUtil.createList(new int[]{1, 2, 3}), 2, 3)), new int[]{1, 3, 2});
		assertArrayEquals(ListUtil.getArrayFrom(r.reverseBetween(ListUtil.createList(new int[]{1, 2, 3}), 1, 3)), new int[]{3, 2, 1});
	}

}
