package leetcode_30;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		Set<Integer> set = new HashSet<>();
		ListNode pre = head;
		ListNode node = head.next;
		set.add(pre.val);
		while (node != null) {
			if (set.contains(node.val)) {
				pre.next = node.next;
				node = pre.next;
			} else {
				set.add(node.val);
				node = node.next;
				pre = pre.next;
			}
		}
        return head;
    }
}
