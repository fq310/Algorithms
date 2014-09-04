package leetcode_20;

import leetcode_30.TreeNode;

import org.junit.Test;

public class RecoverBinarySearchTreeTest {

	@Test
	public void test() {
		test1();
		test2();
	}

	private void test2() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		RecoverBinarySearchTree r = new RecoverBinarySearchTree();
		r.recoverTree(n1);
	}

	private void test1() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n2.left = n3;
		n2.right = n1;
		RecoverBinarySearchTree r = new RecoverBinarySearchTree();
		r.recoverTree(n2);
	}

}
