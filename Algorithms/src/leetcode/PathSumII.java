package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII {
	private class MyNode {
		TreeNode node;
		MyNode parent;
		MyNode left;
		MyNode right;
		int length;
		public MyNode(TreeNode node, MyNode parent) {
			this.node = node;
			this.parent = parent;
			if (parent != null)
				length = parent.length + node.val;
			else 
				length = node.val;
		}
	}
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (root == null) return result;
    	Stack<TreeNode> stack = new Stack<>();
    	Stack<MyNode> stackMyNode = new Stack<>();
    	List<MyNode> leaves = new ArrayList<>();
    	stack.push(root);
    	stackMyNode.push(new MyNode(root, null));
    	while (stack.size() > 0) {
    		TreeNode node = stack.pop();
    		MyNode myNode = stackMyNode.pop();
    		if (node.left != null) {
    			stack.push(node.left);
    			MyNode myNodeLeft = new MyNode(node.left, myNode);
				stackMyNode.push(myNodeLeft);
				myNode.left = myNodeLeft;
    		}
    		if (node.right != null) {
    			stack.push(node.right);
    			MyNode myNodeRight = new MyNode(node.right, myNode);
				stackMyNode.push(myNodeRight);
				myNode.right = myNodeRight;
    		}
    		if (myNode.left == null && myNode.right == null) {
    			leaves.add(myNode);
    		}
    	}
    	for (MyNode node : leaves) {
    		if (node.length == sum) {
    			List<Integer> path = new ArrayList<>();
    			path.add(0, node.node.val);
    			while (node.parent != null) {
    				node = node.parent;
    				path.add(0, node.node.val);
    			}
    			result.add(path);
    		}
    	}
    	return result;
    }
}
