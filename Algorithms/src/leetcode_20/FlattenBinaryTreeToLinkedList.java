package leetcode_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode_30.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
    	if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> nodeList = new ArrayList<>();
        TreeNode node = root;
        while (stack.size() > 0 || node != null) {
        	while (node != null) {
        		nodeList.add(node);
        		stack.push(node);
        		node = node.left;
        	}
        	node = stack.pop();
        	node = node.right;
        }
        
        for (int i = 0; i < nodeList.size() - 1; ++i) {
        	TreeNode n = nodeList.get(i);
        	n.left = null;
        	n.right = nodeList.get(i + 1);
        }
        nodeList.get(nodeList.size() - 1).left = null;
        nodeList.get(nodeList.size() - 1).right = null;
    }
}
