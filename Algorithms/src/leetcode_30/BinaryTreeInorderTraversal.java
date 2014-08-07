package leetcode_30;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		List<Integer> nodeList = new ArrayList<>();
		while (stack.size() > 0 || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			nodeList.add(node.val);
			node = node.right;
		}
	    return nodeList;
	}
}

