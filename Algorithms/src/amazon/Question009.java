package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class Question009 {

	public static void main(String[] args) {
		System.out.println(calculate(new int[]{7, 2, 4}, 9));
		System.out.println(calculate(new int[]{7, 2, 4}, 8));
		System.out.println(calculate(new int[]{7}, 7));
		System.out.println(calculate(new int[]{7}, 1));
		System.out.println(calculate(new int[]{1, 2, 3, 4}, 10));
		System.out.println(calculate(new int[]{1, 2, 3, 4}, 5));
	}
	
	static class Node {
		private int value;
		private int result;
		private int index;
		private Node parent;
		private Node left;
		private Node right;
		private String operator;
		public Node(int value, int index, Node parent) {
			this.value = value;
			this.index = index;
			this.parent = parent;
			if (parent == null) {
				result = value;
			}
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public void setResult(int result) {
			this.result = result;
		}
		@Override
		public String toString() {
			return String.valueOf(value);
		}
		public int getIndex() {
			return index;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
			this.left.setResult(this.getResult() + this.left.getValue());
			this.left.setOperator("+");
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
			this.right.setResult(this.getResult() - this.right.getValue());
			this.right.setOperator("-");
		}
		public int getResult() {
			return result;
		}
		public String getOperator() {
			return operator;
		}
		public void setOperator(String operator) {
			this.operator = operator;
		}
		public Node getParent() {
			return parent;
		}
	}
	private static String calculate(int[] args, int result) {
		String invalid = "Invalid";
		if (args.length == 0) return invalid;
		if (args.length == 1) {
			if (args[0] == result) 
				return args[0] + "=" + result;
			else
				return invalid;
		}
		Node root = new Node(args[0], 0, null);
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		for (int i = 0; i < args.length - 1; ++i) {
			int currentIndex = i;
			Node node = queue.peek();
			if (node == null) break;
			while (node.getIndex() == currentIndex) {
				Node left = new Node(args[currentIndex + 1], currentIndex + 1, node);
				Node right = new Node(args[currentIndex + 1], currentIndex + 1, node);
				node.setLeft(left);
				node.setRight(right);
				queue.poll();
				queue.add(left);
				queue.add(right);
				node = queue.peek();
			}
		}
		for (Node node : queue) {
			if (node.getResult() == result) {
				StringBuilder buffer = new StringBuilder();
				buffer.append(node.getOperator() + node.getValue() + "=" + node.getResult());
				node = node.getParent();
				while (node.getParent() != null) {
					buffer.insert(0, node.getOperator() + node.getValue());
					node = node.getParent();
				}
				buffer.insert(0, node.getValue());
				return buffer.toString();
			}
		}
		
		return invalid;
	}

}
