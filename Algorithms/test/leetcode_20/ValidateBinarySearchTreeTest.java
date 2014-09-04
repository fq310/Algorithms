package leetcode_20;

import static org.junit.Assert.*;
import leetcode_30.TreeNode;

import org.junit.Test;

public class ValidateBinarySearchTreeTest {

	@Test
	public void test() {
		TreeNode n10 = new TreeNode(10);
		TreeNode n5 = new TreeNode(5);
		TreeNode n15 = new TreeNode(15);
		TreeNode n6 = new TreeNode(6);
		TreeNode n20 = new TreeNode(20);
		n10.left = n5;
		n10.right = n15;
		n15.left = n6;
		n15.right = n20;
		ValidateBinarySearchTree v = new ValidateBinarySearchTree();
		assertEquals(v.isValidBST(n10), false);
	}

}
