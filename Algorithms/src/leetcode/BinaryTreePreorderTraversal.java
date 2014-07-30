package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	if (root == null) return result;
    	TreeNode node = root;
    	Stack<TreeNode> stack = new Stack<>();
    	while (!stack.isEmpty() || node != null) {
    		while (node != null) {
    			result.add(node.val);
    			stack.push(node);
    			node = node.left;
    		}
    		node = stack.pop();
    		node = node.right;
    	}
        return result;
    }
}
