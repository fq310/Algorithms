package leetcode_20;

import static org.junit.Assert.*;
import leetcode.util.ListUtil;

import org.junit.Test;

public class ReverseNodesInKGroupTest {

	@Test
	public void test() {
		ReverseNodesInKGroup r = new ReverseNodesInKGroup();
		assertEquals(r.reverseKGroup(ListUtil.createList(new int[]{1}), 2).val, 1);
		assertEquals(r.reverseKGroup(ListUtil.createList(new int[]{1,2,3,4,5}), 1).val, 1);
		assertEquals(r.reverseKGroup(ListUtil.createList(new int[]{1,2,3,4,5}), 2).val, 2);
		assertEquals(r.reverseKGroup(ListUtil.createList(new int[]{1,2,3,4,5}), 3).val, 3);
		assertEquals(r.reverseKGroup(ListUtil.createList(new int[]{1,2,3,4,5}), 4).val, 4);
		assertEquals(r.reverseKGroup(ListUtil.createList(new int[]{1,2,3,4,5}), 5).val, 5);
	}

}
