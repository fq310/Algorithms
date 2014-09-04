package leetcode_20;

import static org.junit.Assert.*;
import leetcode_30.BinaryTreeLevelOrderTraversal;
import leetcode_30.TreeNode;

import org.junit.Test;

public class BinaryTreeZigzagLevelOrderTraversalTest {

	@Test
	public void test() {
		BinaryTreeZigzagLevelOrderTraversal b = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = new TreeNode(3);
		assertEquals(b.zigzagLevelOrder(root).toString(), "[[3]]");
		TreeNode node9 = new TreeNode(9);
		root.left = node9;
		TreeNode node20 = new TreeNode(20);
		root.right = node20;
		TreeNode node15 = new TreeNode(15);
		node20.left = node15;
		TreeNode node7 = new TreeNode(7);
		node20.right = node7;
		assertEquals(b.zigzagLevelOrder(root).toString(), "[[3], [20, 9], [15, 7]]");
	}

}
