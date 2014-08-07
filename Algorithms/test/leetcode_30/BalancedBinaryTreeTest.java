package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.BalancedBinaryTree;
import leetcode_30.TreeNode;

import org.junit.Test;

public class BalancedBinaryTreeTest {

	@Test
	public void test() {
		BalancedBinaryTree p = new BalancedBinaryTree();
		TreeNode root = new TreeNode(5);
		assertEquals(p.isBalanced(root), true);
		TreeNode n4 = new TreeNode(4);
		root.left = n4;
		assertEquals(p.isBalanced(root), true);
		TreeNode n8 = new TreeNode(8);
		root.right = n8;
		assertEquals(p.isBalanced(root), true);
		TreeNode n11 = new TreeNode(11);
		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2);
		n4.left = n11;
		n11.left = n7;
		n11.right = n2;
		assertEquals(p.isBalanced(root), false);
		
		TreeNode node2 = new TreeNode(2);
		root.left = null;
		root.right = node2;
		node2.right = new TreeNode(3);
		assertEquals(p.isBalanced(root), false);
		
		TreeNode node11 = new TreeNode(11);
		root.left = null;
		root.right = node11;
		node11.left = new TreeNode(12);
		assertEquals(p.isBalanced(root), false);
	}

}
