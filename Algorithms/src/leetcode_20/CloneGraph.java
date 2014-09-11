package leetcode_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null) return null;
    	Queue<UndirectedGraphNode> oldQueue = new LinkedList<>();
    	oldQueue.add(node);
    	Set<UndirectedGraphNode> visited = new HashSet<>();
    	Queue<UndirectedGraphNode> newQueue = new LinkedList<>();
    	UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
    	Map<Integer, UndirectedGraphNode> newNodeMap = new HashMap<>();
		newQueue.add(newHead);
    	while (oldQueue.size() > 0) {
    		UndirectedGraphNode oldNode = oldQueue.poll();
    		if (visited.contains(oldNode)) {
    			newQueue.poll();
    			continue;
    		}
    		visited.add(oldNode);
    		UndirectedGraphNode newNode = newQueue.poll();
    		for (UndirectedGraphNode neighbor : oldNode.neighbors) {
    			if (neighbor == oldNode) {
    				newNode.neighbors.add(newNode);
    			} else {
    				UndirectedGraphNode newNeighbor = newNodeMap.get(neighbor.label);
    				if (newNeighbor == null) {
    					newNeighbor = new UndirectedGraphNode(neighbor.label);
    					newNodeMap.put(newNeighbor.label, newNeighbor);
    				}
	    			newNode.neighbors.add(newNeighbor);
	    			oldQueue.add(neighbor);
	    			newQueue.add(newNeighbor);
    			}
    		}
    	}
        return newHead;
    }
}

class UndirectedGraphNode {
	@Override
	public String toString() {
		return String.valueOf(label);
	}
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};