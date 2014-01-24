package cci;

import java.util.List;

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