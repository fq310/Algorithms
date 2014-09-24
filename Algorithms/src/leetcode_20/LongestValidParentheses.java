package leetcode_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LongestValidParentheses {
	class Node {
		public Node(int i, char c) {
			index = i;
			value = c;
		}
		int index;
		char value;
	}
    public int longestValidParentheses(String s) {
    	List<Integer> validIndex = getValidIndex(s);
    	int length = calculateMaxLength(validIndex);
        return length;
    }
	private int calculateMaxLength(List<Integer> validIndex) {
		int start = 0;
    	int end = start + 1;
    	int length = 0;
    	while (end < validIndex.size()) {
    		if (validIndex.get(end - 1) == validIndex.get(end) - 1) {
    			++end;
    		} else {
    			length = Math.max(length, end - start);
    			start = end;
    			++end;
    		}
    	}
    	if (end - start > 1) {
    		length = Math.max(length, end - start);
    	}
		return length;
	}
	private List<Integer> getValidIndex(String s) {
		Stack<Node> stack = new Stack<>();
		List<Node> allChars = new ArrayList<>();
		for (int i = 0; i < s.length(); ++i) {
    		char c = s.charAt(i);
    		allChars.add(new Node(i, c));
		}
    	List<Integer> validIndex = new ArrayList<>();
    	for (int i = 0; i < allChars.size(); ++i) {
    		Node node = allChars.get(i);
    		if (stack.size() > 0 && stack.peek().value == '(' && node.value == ')') {
    			Node leftNode = stack.pop();
    			validIndex.add(leftNode.index);
    			validIndex.add(node.index);
    		} else {
    			stack.push(node);
    		}
    	}
    	Collections.sort(validIndex);
		return validIndex;
	}
}
