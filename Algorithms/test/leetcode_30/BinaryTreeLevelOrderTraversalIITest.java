package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.BinaryTreeLevelOrderTraversalII;
import leetcode_30.TreeNode;

import org.junit.Test;

public class BinaryTreeLevelOrderTraversalIITest {

	@Test
	public void test() {
		BinaryTreeLevelOrderTraversalII b = new BinaryTreeLevelOrderTraversalII();
		TreeNode root = new TreeNode(3);
		assertEquals(b.levelOrderBottom(root).toString(), "[[3]]");
		TreeNode node9 = new TreeNode(9);
		root.left = node9;
		TreeNode node20 = new TreeNode(20);
		root.right = node20;
		TreeNode node15 = new TreeNode(15);
		node20.left = node15;
		TreeNode node7 = new TreeNode(7);
		node20.right = node7;
		assertEquals(b.levelOrderBottom(root).toString(), "[[15, 7], [9, 20], [3]]");
	}

}
