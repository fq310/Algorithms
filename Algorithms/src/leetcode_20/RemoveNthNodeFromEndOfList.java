package leetcode_20;

import java.util.ArrayList;
import java.util.List;

import leetcode_30.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	List<ListNode> list = new ArrayList<>();
    	ListNode preHead = new ListNode(0);
    	preHead.next = head;
		list.add(preHead);
    	while (head != null) {
    		list.add(head);
    		head = head.next;
    	}
    	ListNode pre = list.get(list.size() - n - 1);
    	ListNode next = null;
    	if (list.size() - n + 1 < list.size()) {
    		next = list.get(list.size() - n + 1);
    	}
    	pre.next = next;
        return preHead.next;
    }
}
