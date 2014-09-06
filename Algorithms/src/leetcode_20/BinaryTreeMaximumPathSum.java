package leetcode_20;

import leetcode_30.TreeNode;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        search(root, result);
        return result[0];
    }

	private int search(TreeNode node, int[] result) {
		if (node == null) return 0;
		
		int leftMaxSum = search(node.left, result);
		int rightMaxSum = search(node.right, result);
		
		int maxValue = Math.max(node.val, Math.max(node.val + leftMaxSum, node.val + rightMaxSum));
		result[0] = Math.max(result[0], Math.max(maxValue, leftMaxSum + node.val + rightMaxSum));
		return result[0];
	}

}
