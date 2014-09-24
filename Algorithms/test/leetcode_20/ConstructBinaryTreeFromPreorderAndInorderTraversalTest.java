package leetcode_20;

import leetcode_30.TreeNode;

import org.junit.Test;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

	@Test
	public void test() {
		ConstructBinaryTreeFromPreorderAndInorderTraversal c = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		n3.left = n5;
		
		c.buildTree(new int[]{1,2,4,3,5}, new int[]{2,4,1,5,3});
		
	}

}
