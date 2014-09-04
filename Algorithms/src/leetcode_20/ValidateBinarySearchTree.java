package leetcode_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode_30.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
    	Stack<TreeNode> stack = new Stack<>();
    	List<TreeNode> nodes = new ArrayList<>();
    	TreeNode node = root;
    	while (stack.size() > 0 || node != null) {
    		while (node != null) {
    			stack.push(node);
    			node = node.left;
    		}
    		node = stack.pop();
    		nodes.add(node);
    		node = node.right;
    	}
    	for (int i = 0; i < nodes.size() - 1; ++i) {
    		if (nodes.get(i).val >= nodes.get(i + 1).val)
    			return false;
    	}
        return true;
    }
}
