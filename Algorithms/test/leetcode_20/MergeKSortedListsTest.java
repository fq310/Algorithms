package leetcode_20;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.ListUtil;
import leetcode_30.ListNode;

import org.junit.Test;

public class MergeKSortedListsTest {

	@Test
	public void test() {
		MergeKSortedLists m = new MergeKSortedLists();
		List<ListNode> lists = new ArrayList<>();
		lists.add(ListUtil.createList(new int[]{1,3,5,7}));
		lists.add(ListUtil.createList(new int[]{2,4,6,8}));
		lists.add(ListUtil.createList(new int[]{0,9}));
		assertEquals(m.mergeKLists(lists).toString(), "0");
	}

}
