package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.PathSumII;
import leetcode_30.TreeNode;

import org.junit.Test;

public class PathSumIITest {

	@Test
	public void test() {
		PathSumII p = new PathSumII();
		TreeNode root = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		root.left = n4;
		TreeNode n8 = new TreeNode(8);
		root.right = n8;
		TreeNode n11 = new TreeNode(11);
		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2);
		n4.left = n11;
		n11.left = n7;
		n11.right = n2;
		assertEquals(p.pathSum(root, 22).toString(), "[[5, 4, 11, 2]]");
		
		
	}
}
