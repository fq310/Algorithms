package leetcode;

/*
 * when there is only one root node, the height is 1.
 */
public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int left = 1 + maxDepth(root.left);
		int right = 1 + maxDepth(root.right);
		if (left > right) return left;
		else return right;
    }
}

