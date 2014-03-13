package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question007 {

	public static void main(String[] args) {
		Question007 q = new Question007();
		System.out.println(q.interval(3, new int[]{3, 4, 1, 2, 5, 6}));
		System.out.println(q.interval(2, new int[]{1, 4, 2 ,3}));
		System.out.println(q.interval(2, new int[]{1, 2}));
		System.out.println(q.interval(2, new int[]{1, 5, 3, 7}));
		System.out.println(q.interval(2, new int[]{1, 5, 3, 5}));
		System.out.println(q.interval(2, new int[]{1, 5, 1, 4}));
	}
	
	class Node {
		int value;
		boolean isStart;
		Node relatedNode;
		public Node(int value, boolean isStart) {
			this.value = value;
			this.isStart = isStart;
		}
		@Override
		public int hashCode() {
			int hash = 17;
			hash = 31*hash + value;
			hash = 31*hash + (isStart == true ? 1 : 0);
			hash = 31*hash + relatedNode.value;
			return hash;
		}
		@Override
		public boolean equals(Object y) {
			if (y == this) return true;
			if (y == null) return false;
			if (y.getClass() != this.getClass())
				return false;
			Node that = (Node) y;
			if (that.value != this.value) return false;
			if (that.isStart != this.isStart) return false;
			if (that.relatedNode.value != this.relatedNode.value) return false;
			return true;
		}
		
		public int getValue() {
			return value;
		}
		
		@Override
		public String toString() {
			return String.valueOf(value);
		}
		public boolean isStart() {
			return isStart;
		}
		public Node getRelatedNode() {
			return relatedNode;
		}
		public void setRelatedNode(Node relatedNode) {
			this.relatedNode = relatedNode;
		}
	}
	
	private int interval(int n, int[] intervals) {
		List<Node> sorted = new ArrayList<Node>();
		for (int i = 0; i < intervals.length; ++i) {
			Node start = new Node(intervals[i], true);
			Node end = new Node(intervals[++i], false);
			start.setRelatedNode(end);
			end.setRelatedNode(start);
			sorted.add(start);
			sorted.add(end);
		}
		Collections.sort(sorted, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.value == o2.value) return 0;
				if (o1.value > o2.value) return 1;
				return -1;
			}
		});
		List<Node> startNodes = new ArrayList<Node>();
		List<Node> endNodes = new ArrayList<Node>();
		for (Node node : sorted) {
			if (node.isStart()) {
				startNodes.add(node);
				endNodes.add(node.getRelatedNode());
			} else {
				Node start = node.getRelatedNode();
				endNodes.remove(node);
				startNodes.remove(start);
				for (Node startNode : startNodes) {
					Node end = startNode.getRelatedNode();
					if (endNodes.contains(end) && (
							(node.getValue() <= end.getValue() &&
							start.getValue() >= startNode.getValue()) ||
							(node.getValue() >= end.getValue() &&
							start.getValue() <= startNode.getValue())
							)) {
						return 1;
					}
				}
			}
		}
		return 0;
	}

}
