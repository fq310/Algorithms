package leetcode_20;

import java.util.List;

import leetcode_30.ListNode;

public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
    	if (lists.isEmpty()) return null;
    	while (lists.size() > 1) {
    		ListNode list1 = lists.get(0);
    		ListNode list2 = lists.get(1);
    		lists.remove(0);
    		lists.remove(0);
    		lists.add(0, mergeTwoLists(list1, list2));
    	}
    	return lists.get(0);
    }
    
    //from MergeTwoSortedLists.java
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode head = new ListNode(0);
    	ListNode node = head;
    	while (l1 != null && l2 != null) {
    		if (l1.val < l2.val) {
    			node.next = l1;
    			l1 = l1.next;
    		} else {
    			node.next = l2;
    			l2 = l2.next;
    		}
    		node = node.next;
    	}
    	while (l1 != null) {
    		node.next = l1;
    		node = node.next;
    		l1 = l1.next;
    	}
    	while (l2 != null) {
    		node.next = l2;
    		node = node.next;
    		l2 = l2.next;
    	}
        return head.next;
    }
}
