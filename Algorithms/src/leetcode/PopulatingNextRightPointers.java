package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
	public void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() > 0) {
			Queue<TreeLinkNode> childQueue = new LinkedList<>();
			while (!queue.isEmpty()) {
				TreeLinkNode node1 = queue.poll();
				if (node1 == null) break;
				addChildren(childQueue, node1);
				TreeLinkNode node2 = queue.peek();
				node1.next = node2;
			}
			queue.addAll(childQueue);
		}
	}

	private void addChildren(Queue<TreeLinkNode> childQueue, TreeLinkNode node) {
		if (node.left != null)
			childQueue.add(node.left);
		if (node.right != null)
			childQueue.add(node.right);
	}
}
