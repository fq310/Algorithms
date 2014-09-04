package leetcode_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode_30.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = levelOrder(root);
    	int i = 1;
    	for (List<Integer> line : result) {
    		if (i < 0) {
    			Collections.reverse(line);
    		}
    		i *= -1;
    	}
    	return result;
    }
    
    private List<List<Integer>> levelOrder(TreeNode root) {
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
