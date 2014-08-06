package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeInorderTraversalTest {

	@Test
	public void test() {
		BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(3);
		assertEquals(b.inorderTraversal(root).toString(), "[3]");
		TreeNode node9 = new TreeNode(9);
		root.left = node9;
		TreeNode node20 = new TreeNode(20);
		root.right = node20;
		assertEquals(b.inorderTraversal(root).toString(), "[9, 3, 20]");
		TreeNode node15 = new TreeNode(15);
		node20.left = node15;
		TreeNode node7 = new TreeNode(7);
		node20.right = node7;
		assertEquals(b.inorderTraversal(root).toString(), "[9, 3, 15, 20, 7]");
	}

}
