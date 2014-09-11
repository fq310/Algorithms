package leetcode_20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions {
	private final char O = 'O';
	private final char X = 'X';
	class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "[" + x + ", " + y + "]";
		}
	}
    public void solve(char[][] board) {
    	if (board.length == 0) return;
        List<Node> allONode = getONode(board);
        boolean[][] surroundedNode = new boolean[board.length][board[0].length];
        boolean[][] allVisitedONode = new boolean[board.length][board[0].length];
        for (Node node : allONode) {
        	if (allVisitedONode[node.x][node.y]) continue;
        	boolean[][] visitedONode = new boolean[board.length][board[0].length];
        	boolean isSurrounded = traverse(node, board, visitedONode);
        	if (isSurrounded) {
        		addNode(surroundedNode, visitedONode);
        	}
        	addNode(allVisitedONode, visitedONode);
        }
        
        for (int i = 0; i < surroundedNode.length; ++i) {
			for (int j = 0; j < surroundedNode[i].length; ++j) {
				if (surroundedNode[i][j])
					board[i][j] = X;
			}
		}
    }
	private void addNode(boolean[][] surroundedNode, boolean[][] visitedONode) {
		for (int i = 0; i < visitedONode.length; ++i) {
			for (int j = 0; j < visitedONode[i].length; ++j) {
				if (visitedONode[i][j])
					surroundedNode[i][j] = true;
			}
		}
	}
	private boolean traverse(Node n, char[][] board, boolean[][] visitedONode) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(n);
		while (queue.size() > 0) {
			Node node = queue.poll();
			int x = node.x, y = node.y;
			if (visitedONode[x][y]) continue;
			visitedONode[x][y] = true;
			int topX = x - 1, leftY = y - 1, bottomX = x + 1, rightY = y + 1;
			if (topX < 0 || leftY < 0 || bottomX >= board.length || rightY >= board[0].length) return false;
			if (board[topX][y] == O) queue.add(new Node(topX, y));
			if (board[bottomX][y] == O) queue.add(new Node(bottomX, y));
			if (board[x][leftY] == O) queue.add(new Node(x, leftY));
			if (board[x][rightY] == O) queue.add(new Node(x, rightY));
		}
		return true;
	}
	private List<Node> getONode(char[][] board) {
		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				if (board[i][j] == 'O')
					nodes.add(new Node(i, j));
			}
		}
		return nodes;
	}
}
