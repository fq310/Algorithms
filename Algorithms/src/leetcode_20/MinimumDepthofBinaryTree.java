package leetcode_20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode_30.TreeNode;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
    	List<List<TreeNode>> nodes = levelOrder(root);
    	for (int i = 0; i < nodes.size(); ++i) {
    		List<TreeNode> row = nodes.get(i);
    		for (TreeNode node : row) {
    			if (node.left == null && node.right == null) {
    				return i + 1;
    			}
    		}
    	}
        return 1;
    }
    
    private List<List<TreeNode>> levelOrder(TreeNode root) {
    	List<List<TreeNode>> result = new ArrayList<>();
    	if (root == null) return result;
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while (queue.size() > 0) {
    		List<TreeNode> row = new ArrayList<>();
    		Queue<TreeNode> child = new LinkedList<>();
    		while (queue.size() > 0) {
    			TreeNode node = queue.poll();
    			row.add(node);
    			if (node.left != null)
    				child.add(node.left);
    			if (node.right != null)
    				child.add(node.right);
    		}
    		result.add(row);
    		queue.addAll(child);
    	}
        return result;
    }
}
