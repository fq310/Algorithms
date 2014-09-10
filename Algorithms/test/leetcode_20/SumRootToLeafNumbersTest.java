package leetcode_20;

import static org.junit.Assert.*;
import leetcode_30.TreeNode;

import org.junit.Test;

public class SumRootToLeafNumbersTest {

	@Test
	public void test() {
		SumRootToLeafNumbers s = new SumRootToLeafNumbers();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		assertEquals(s.sumNumbers(n1), 25);
	}

}
