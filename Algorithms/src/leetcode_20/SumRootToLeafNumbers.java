package leetcode_20;

import leetcode_30.TreeNode;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
    	int[] allSum = new int[1];
    	search(root, "", allSum);
        return allSum[0];
    }

	private void search(TreeNode root, String numbers, int[] allSum) {
		if (root == null) return;
		numbers += root.val;
		if (root.left == null && root.right == null) {
			allSum[0] += Integer.parseInt(numbers);
			return;
		}
		if (root.left != null) {
			search(root.left, numbers, allSum);
		}
		if (root.right != null) {
			search(root.right, numbers, allSum);
		}
	}

}
