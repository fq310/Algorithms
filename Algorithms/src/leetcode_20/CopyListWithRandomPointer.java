package leetcode_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if (head == null) return null;
    	RandomListNode node = head;
    	Map<RandomListNode, RandomListNode> map = new HashMap<>();
    	while (node != null) {
    		RandomListNode newNode = new RandomListNode(node.label);
    		map.put(node, newNode);
    		node = node.next;
    	}
    	for (Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
    		RandomListNode oldNode = entry.getKey();
    		RandomListNode newNode = entry.getValue();
    		newNode.next = map.get(oldNode.next);
    		newNode.random = map.get(oldNode.random);
    	}
        return map.get(head);
    }
}


class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
};