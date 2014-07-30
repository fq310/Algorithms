package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SameTreeTest {

	@Test
	public void test() {
		SameTree s = new SameTree();
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		assertEquals(s.isSameTree(r1, r2), false);
		r2.val = 1;
		assertEquals(s.isSameTree(r1, r2), true);
		r1.left = new TreeNode(1);
		r2.left = new TreeNode(2);
		assertEquals(s.isSameTree(r1, r2), false);
		r2.left.val = 1;
		assertEquals(s.isSameTree(r1, r2), true);
		r2.right = r2.left;
		r2.left = null;
		assertEquals(s.isSameTree(r1, r2), false);
	}

}
