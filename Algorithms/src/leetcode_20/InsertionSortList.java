package leetcode_20;

import java.util.ArrayList;
import java.util.List;

import leetcode_30.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
    	if (head == null) return null;
    	List<ListNode> list = new ArrayList<>();
    	ListNode node = head;
    	while (node != null) {
    		list.add(node);
    		node = node.next;
    	}
    	for (int i = 1; i < list.size(); ++i) {
    		ListNode currentNode = list.get(i);
    		int j = i - 1;
    		for (; j >= 0; --j) {
    			ListNode nodeJ = list.get(j);
				if (nodeJ.val > currentNode.val)
    				list.set(j + 1, nodeJ);
				else
					break;
    		}
    		list.set(j + 1, currentNode);
    	}
    	for (int i = 0; i < list.size() - 1; ++i) {
    		list.get(i).next = list.get(i + 1);
    	}
    	list.get(list.size() - 1).next = null;
        return list.get(0);
    }
}
