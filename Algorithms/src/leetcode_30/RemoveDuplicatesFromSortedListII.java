package leetcode_30;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null) return head;
    	ListNode preHead = new ListNode(-1);
    	preHead.next = head;
    	ListNode pre = preHead;
    	ListNode current = head;
    	ListNode node = current;
    	while (node != null) {
	    	while (node.next != null && node.val == node.next.val) {
	    		node = node.next;
	    	}
	    	if (current != node) {
	    		pre.next = node.next;
	    		current = node.next;
	    		node = node.next;
	    	} else {
	    		pre = node;
	    		current = node.next;
	    		node = node.next;
	    	}
    	}
        return preHead.next;
    }
}
