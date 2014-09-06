package leetcode_20;

import static org.junit.Assert.*;
import leetcode_30.TreeNode;

import org.junit.Test;

public class BinaryTreeMaximumPathSumTest {

	@Test
	public void test() {
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		assertEquals(b.maxPathSum(node1), 6);
	}

}
