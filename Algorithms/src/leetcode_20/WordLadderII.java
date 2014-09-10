package leetcode_20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	dict.add(end);
    	Map<String, Set<String>> graph = createGraph(start, end, dict);
    	List<List<String>> shortestPaths = searchGraph(start, end, graph);
        return shortestPaths;
    }
	private List<List<String>> searchGraph(String start, String end,
			Map<String, Set<String>> graph) {
		List<List<String>> shortestPaths = new LinkedList<>();
    	Set<String> endList = graph.get(end);
    	if (endList == null || endList.size() == 0) return shortestPaths;
    	LinkedList<String> path = new LinkedList<String>();
    	path.add(end);
		search(graph, start, end, path, shortestPaths);
		return shortestPaths;
	}
	private Map<String, Set<String>> createGraph(String start, String end,
			Set<String> dict) {
		Map<String, Set<String>> graph = new HashMap<>();
    	Set<String> preLevelStr = new HashSet<>();
    	Set<String> thisLevelStr = new HashSet<>();
    	thisLevelStr.add(start);
    	boolean ladderFound = false;
    	while (ladderFound == false) {
    		Set<String> nextLevelStr = new HashSet<>();
    		for (String str : thisLevelStr) {
    			char[] strArray = str.toCharArray();
    			for (int i = 0; i < strArray.length; ++i) {
    				char oldChar = strArray[i];
    				for (char c = 'a'; c <= 'z'; ++c) {
    					if (c == strArray[i]) continue;
    					strArray[i] = c;
    					String newStr = new String(strArray);
    					if (newStr.equals(end)) {
    						ladderFound = true;
    						nextLevelStr.add(newStr);
    						addToGraph(graph, str, newStr);
    						continue;
    					}
    					if (!dict.contains(newStr) || preLevelStr.contains(newStr) || thisLevelStr.contains(newStr)) continue;
						nextLevelStr.add(newStr);
						addToGraph(graph, str, newStr);
    				}
    				strArray[i] = oldChar;
    			}
    		}
    		preLevelStr = thisLevelStr;
    		thisLevelStr = nextLevelStr;
    		if (ladderFound || thisLevelStr.isEmpty()) break;
    	}
		return graph;
	}
	private void addToGraph(Map<String, Set<String>> graph, String str,
			String newStr) {
		if (graph.get(newStr) == null) {
			graph.put(newStr, new HashSet<String>());
		}
		graph.get(newStr).add(str);
	}
	private void search(Map<String, Set<String>> graph, String start,
			String current, List<String> path, List<List<String>> shortestPaths) {
		if (current == null) return;
		if (current == start) {
			shortestPaths.add(path);
			return;
		}
		Set<String> parent = graph.get(current);
		if (parent == null) return;
		for (String str : parent) {
			List<String> newPath = new LinkedList<>();
			newPath.addAll(path);
			newPath.add(0, str);
			search(graph, start, str, newPath, shortestPaths);
		}
	}
}
