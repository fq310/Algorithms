package leetcode_20;

import leetcode_30.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (k == 0 || k == 1) return head;
    	ListNode preHead = new ListNode(0);
    	preHead.next = head;
    	ListNode start = head;
    	ListNode end = start;
    	for (int i = 0; i < k - 1; ++i) {
    		if (end == null) return preHead.next;
    		end = end.next;
    	}
    	if (end == null) return preHead.next;
    	ListNode preStart = preHead;
    	ListNode afterEnd = end.next; 
    	while (true) {
    		reverseNodes(preStart, start, end, afterEnd);
    		ListNode  temp = end;
    		end = start;
    		start = temp;
    		preStart = end;
    		for (int i = 0; i < k; ++i) {
        		if (end == null) return preHead.next;
        		end = end.next;
        		start = start.next;
        	}
    		if (end == null) break;
    		afterEnd = end.next;
    	}
        return preHead.next;
    }
    
	private void reverseNodes(ListNode preStart, ListNode start, ListNode end, ListNode afterEnd) {
    	ListNode node = start.next;
    	start.next = afterEnd;
    	while (start != end) {
    		ListNode temp = node.next;
    		node.next = start;
    		start = node;
    		node = temp;
    	}
    	preStart.next = end;
    	
    }
}
