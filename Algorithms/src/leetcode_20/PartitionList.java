package leetcode_20;

import leetcode_30.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
    	ListNode smallHead = new ListNode(0);
    	ListNode small = smallHead;
    	ListNode biggerHead = new ListNode(0);
    	ListNode bigger = biggerHead;
    	ListNode node = head;
    	while (node != null) {
    		if (node.val < x) {
    			small.next = node;
    			small = small.next;
    		} else {
    			bigger.next = node;
    			bigger = bigger.next;
    		}
    		node = node.next;
    	}
    	small.next = biggerHead.next;
    	bigger.next = null;
        return smallHead.next;
    }
}
