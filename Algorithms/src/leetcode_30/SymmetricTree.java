package leetcode_30;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    	if (root == null) return true;
    	return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode a, TreeNode b) {
    	if (a == null && b == null) return true;
    	if (a == null || b == null) return false;
    	if (a.val != b.val) return false;
    	return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
}
