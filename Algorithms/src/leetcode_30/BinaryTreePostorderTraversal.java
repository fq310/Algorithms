package leetcode_30;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(result, root);
        return result;
    }
    
    private void postOrder(List<Integer> result, TreeNode node) {
    	if (node == null) return;
    	postOrder(result, node.left);
    	postOrder(result, node.right);
    	result.add(node.val);
    }
}
