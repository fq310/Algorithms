package leetcode;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
    	if (root == null) return true;
    	int lheight = maxDepth(root.left);
    	int rheight = maxDepth(root.right);
    	if (Math.abs(lheight - rheight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

	private int maxDepth(TreeNode node) {
		if (node == null) return 0;
		int left = maxDepth(node.left);
		int right = maxDepth(node.right);
		return 1 + (left > right ? left : right);
	}

}
