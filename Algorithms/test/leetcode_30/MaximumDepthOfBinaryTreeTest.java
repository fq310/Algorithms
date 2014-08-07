package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.MaximumDepthOfBinaryTree;
import leetcode_30.TreeNode;

import org.junit.Test;

public class MaximumDepthOfBinaryTreeTest {

	@Test
	public void test() {
		MaximumDepthOfBinaryTree b = new MaximumDepthOfBinaryTree();
		assertEquals(b.maxDepth(null), 0);
		TreeNode node = new TreeNode(0);
		assertEquals(b.maxDepth(node), 1);
		node.left = new TreeNode(0);
		assertEquals(b.maxDepth(node), 2);
		node.right = new TreeNode(0);
		assertEquals(b.maxDepth(node), 2);
		node.left.left = new TreeNode(0);
		assertEquals(b.maxDepth(node), 3);
		node.left.left.left = new TreeNode(0);
		assertEquals(b.maxDepth(node), 4);
	}

}
