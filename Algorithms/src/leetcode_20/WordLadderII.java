package leetcode_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	class Node {
		public Node(String str) {
			this.str = str;
			path.add(str);
		}
		String str;
		List<String> path = new LinkedList<>();
		@Override
		public String toString() {
			return str;
		}
	}
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	dict.add(end);
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(new Node(start));
    	Set<String> visitedStr = new HashSet<>();
    	List<List<String>> shortestPaths = new ArrayList<>();
    	while (queue.size() > 0) {
    		Node node = queue.poll();
    		String str = node.str;
    		if (node.path.size() > dict.size() + 1) continue;
    		char[] charArray = str.toCharArray();
			for (int i = 0; i < charArray.length; ++i) {
				char oldCharI = charArray[i];
    			for (char c = 'a'; c <= 'z'; ++c) {
    				if (c == charArray[i]) continue;
    				charArray[i] = c;
    				String newStr = new String(charArray);
    				if (newStr.equals(end)) {
    					List<String> path = new ArrayList<>();
    	    			path.addAll(node.path);
    	    			path.add(newStr);
    	    			shortestPaths.add(path);
    	    			continue;
    	    		}
    				if (!dict.contains(newStr) || visitedStr.contains(newStr)) continue;
    				visitedStr.add(newStr);
					Node newNode = new Node(newStr);
    				newNode.path.addAll(0, node.path);
    				queue.add(newNode);
    			}
    			charArray[i] = oldCharI;
    		}
			
    	}
        return shortestPaths;
    }
}
