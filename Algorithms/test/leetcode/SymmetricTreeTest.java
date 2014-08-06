package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SymmetricTreeTest {

	@Test
	public void test() {
		SymmetricTree b = new SymmetricTree();
		TreeNode root = new TreeNode(3);
		assertEquals(b.isSymmetric(root), true);
		TreeNode node9 = new TreeNode(9);
		root.left = node9;
		TreeNode node20 = new TreeNode(9);
		root.right = node20;
		assertEquals(b.isSymmetric(root), true);
		TreeNode node15 = new TreeNode(15);
		node20.left = node15;
		TreeNode node7 = new TreeNode(7);
		node20.right = node7;
		assertEquals(b.isSymmetric(root), false);
		
		
	}

}
