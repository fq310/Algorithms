package leetcode_30;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
