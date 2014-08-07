package leetcode_30;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
    	if (head == null) return false;
    	ListNode fast = head;
    	ListNode slow = head;
    	while (fast != null && slow != null) {
    		fast = fast.next;
    		if (fast == null) return false;
    		fast = fast.next;
    		if (fast == null) return false;
    		fast = fast.next;
    		if (fast == null) return false;
    		
    		slow = slow.next;
    		if (slow == null) return false;
    		slow = slow.next;
    		if (slow == null) return false;
    		
    		if (fast == slow) return true;
    	}
        return false;
    }
}
