package leetcode_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Subsets {
	class Node {
		List<Integer> value = new ArrayList<>();
		int index;
		public Node(int index, int value) {
			this.index = index;
			this.value.add(value);
		}
		@Override
		public String toString() {
			return "Node [value=" + value + ", index=" + index + "]";
		}
	}
    public List<List<Integer>> subsets(int[] S) {
    	Arrays.sort(S);
    	Queue<Node> queue = new LinkedList<>();
    	for (int i = 0 ; i < S.length; ++i) {
    		queue.add(new Node(i, S[i]));
    	}
    	List<List<Integer>> result = new ArrayList<>();
    	result.add(new ArrayList<Integer>());
    	while (queue.size() > 0) {
    		Node node = queue.poll();
    		result.add(node.value);
    		for (int i = node.index + 1; i < S.length; ++i) {
    			Node newNode = new Node(i, S[i]);
    			newNode.value.addAll(0, node.value);
    			queue.add(newNode);
    		}
    	}
        return result;
    }
}
