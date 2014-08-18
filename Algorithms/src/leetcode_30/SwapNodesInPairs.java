package leetcode_30;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
    	if (head == null) return null;
    	ListNode node = head;
    	ListNode next = head.next;
    	if (next == null) return head;
    	ListNode newHead = new ListNode(0);
    	newHead.next = head;
    	ListNode pre = newHead;
    	while (next != null) {
    		node.next = next.next;
    		next.next = node;
    		pre.next = next;
    		
    		pre = node;
    		node = node.next;
    		if (node != null)
    			next = node.next;
    		else
    			next = null;
    		
    	}
        return newHead.next;
    }
}
