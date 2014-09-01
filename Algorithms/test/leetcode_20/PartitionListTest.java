package leetcode_20;

import static org.junit.Assert.*;
import leetcode.util.ListUtil;
import leetcode_30.ListNode;

import org.junit.Test;

public class PartitionListTest {

	@Test
	public void test() {
		PartitionList p = new PartitionList();
		ListNode list = ListUtil.createList(new int[]{1, 4, 3, 2, 5, 2});
		assertEquals(p.partition(list, 3).toString(), "1");
		list = ListUtil.createList(new int[]{2, 1});
		assertEquals(p.partition(list, 2).toString(), "1");
	}

}
