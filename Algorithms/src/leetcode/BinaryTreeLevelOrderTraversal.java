package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (root == null) return result;
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while (queue.size() > 0) {
    		List<Integer> row = new ArrayList<>();
    		Queue<TreeNode> child = new LinkedList<>();
    		while (queue.size() > 0) {
    			TreeNode node = queue.poll();
    			row.add(node.val);
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
