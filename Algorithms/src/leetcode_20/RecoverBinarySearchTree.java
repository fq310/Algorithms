package leetcode_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode_30.TreeNode;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        List<TreeNode> inOrderNodes = getInOrderList(stack, node);
        int breakIndex = 0;
        for (int i = 0; i < inOrderNodes.size() - 1; ++i) {
        	if (inOrderNodes.get(i).val < inOrderNodes.get(i + 1).val) {
        		++breakIndex;
        	} else {
        		break;
        	}
        }
        
        int swapIndex = breakIndex + 1;
        for (; swapIndex < inOrderNodes.size(); ++swapIndex) {
        	if (inOrderNodes.get(breakIndex).val < inOrderNodes.get(swapIndex).val) {
        		break;
        	}
        }
        --swapIndex;
        int temp = inOrderNodes.get(breakIndex).val;
        inOrderNodes.get(breakIndex).val = inOrderNodes.get(swapIndex).val;
        inOrderNodes.get(swapIndex).val = temp;
    }

	private List<TreeNode> getInOrderList(Stack<TreeNode> stack, TreeNode node) {
		List<TreeNode> inOrderNodes = new ArrayList<>();
        while (!stack.isEmpty() || node != null) {
        	while (node != null) {
        		stack.push(node);
        		node = node.left;
        	}
        	node = stack.pop();
			inOrderNodes.add(node);
			node = node.right;
        }
		return inOrderNodes;
	}
}
