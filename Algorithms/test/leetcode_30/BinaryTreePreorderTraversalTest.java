package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.BinaryTreePreorderTraversal;
import leetcode_30.TreeNode;

import org.junit.Test;

public class BinaryTreePreorderTraversalTest {

	@Test
	public void test() {
		BinaryTreePreorderTraversal b = new BinaryTreePreorderTraversal();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		assertEquals(b.preorderTraversal(root).toString(), "[1, 2]");
	}

}
