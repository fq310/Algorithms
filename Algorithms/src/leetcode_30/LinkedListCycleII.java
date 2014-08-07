package leetcode_30;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (hasCycle(head) == false) return null;
		Set<ListNode> set = new HashSet<>();
		set.add(head);
		while (!set.contains(head.next)) {
			head = head.next;
			set.add(head);
		}
        return head.next;
    }
	
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
