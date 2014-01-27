package cci;

import java.util.List;
import java.util.Stack;

public class Chapter4 {
	public void preOrderTraversal(BNode node, List<BNode> nodeList) {
		if (node == null) return;
		nodeList.add(node);
		preOrderTraversal(node.left, nodeList);
		preOrderTraversal(node.right, nodeList);
	}
	
	public void inOrderTraversal(BNode node, List<BNode> nodeList) {
		if (node == null) return;
		inOrderTraversal(node.left, nodeList);
		nodeList.add(node);
		inOrderTraversal(node.right, nodeList);
	}
	
	public void postOrderTraversal(BNode node, List<BNode> nodeList) {
		if (node == null) return;
		postOrderTraversal(node.left, nodeList);
		postOrderTraversal(node.right, nodeList);
		nodeList.add(node);
	}
	
	public void preOrder(BNode root, List<BNode> nodeList) {
		BNode node = root;
		Stack<BNode> stack = new Stack<BNode>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				nodeList.add(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				BNode n = stack.pop();
				node = n.right;
			}
		}
	}
	
	public void inOrder(BNode root, List<BNode> nodeList) {
		BNode node = root;
		Stack<BNode> stack = new Stack<BNode>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				BNode n = stack.pop();
				nodeList.add(n);
				node = n.right;
			}
		}
	}
	
}


class BNode {
	int value;
	BNode left;
	BNode right;
	
	public BNode(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}