package leetcode_20;

import java.util.Arrays;
import java.util.Comparator;

public class TwoSum {
	class Node {
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
		int value;
		int index;
	}
    public int[] twoSum(int[] numbers, int target) {
    	Node[] nodes = new Node[numbers.length];
    	for (int i = 0; i < numbers.length; ++i) {
    		nodes[i] = new Node(i + 1, numbers[i]);
    	}
        Arrays.sort((nodes), new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.value < o2.value) return -1;
				if (o1.value > o2.value) return 1;
				return 0;
			}
        });
        int left = 0, right = nodes.length - 1;
        while (left < right) {
            int sum = nodes[left].value + nodes[right].value;
            if (sum == target) break;
            if (sum < target) ++left;
            if (sum > target) --right;
        }
        
        if (nodes[left].index > nodes[right].index) {
        	return new int[]{nodes[right].index, nodes[left].index};
        } else {
        	return new int[]{nodes[left].index, nodes[right].index};
        }
    }
}
