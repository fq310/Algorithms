package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.PathSum;
import leetcode_30.TreeNode;

import org.junit.Test;

public class PathSumTest {

	@Test
	public void test() {
		PathSum p = new PathSum();
		TreeNode root = new TreeNode(5);
		assertEquals(p.hasPathSum(root, 5), true);
		assertEquals(p.hasPathSum(root, 3), false);
		TreeNode n4 = new TreeNode(4);
		root.left = n4;
		TreeNode n8 = new TreeNode(8);
		root.right = n8;
		assertEquals(p.hasPathSum(root, 9), true);
		assertEquals(p.hasPathSum(root, 13), true);
		TreeNode n11 = new TreeNode(11);
		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2);
		n4.left = n11;
		n11.left = n7;
		n11.right = n2;
		assertEquals(p.hasPathSum(root, 22), true);
		assertEquals(p.hasPathSum(root, 23), false);
	}

}
