package leetcode_20;

import leetcode_30.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (m == n) return head;
    	ListNode preStartNode = getPreStartNode(head, m);
    	ListNode startNode = preStartNode.next;
    	
    	ListNode node1 = preStartNode;
    	ListNode node2 = preStartNode.next;
    	if (node2 == null) return head;
    	ListNode node3 = node2.next;
    		
    	for (int i = m; i <= n; ++i) {
    		node2.next = node1;
    		node1 = node2;
    		node2 = node3;
    		if (node3 != null)
    			node3 = node3.next;
    	}
    	startNode.next = node2;
    	preStartNode.next = node1;
    	if (m == 1) return preStartNode.next;
        return head;
    }
    
	private ListNode getPreStartNode(ListNode head, int m) {
    	ListNode preHead;
    	if (m == 1) {
    		preHead = new ListNode(0);
    		preHead.next = head;
    	} else {
    		preHead = head;
    		for (int i = 1; i < m - 1; ++i) {
    			preHead = preHead.next;
    		}
    	}
		return preHead;
	}
}
