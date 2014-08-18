package leetcode_20;

import leetcode_30.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	//make sure node1 is the longer one
    	int count1 = count(l1);
    	int count2 = count(l2);
    	ListNode node1, node2, head;
    	if(count1 > count2) {
    		node1 = l1; node2 = l2;
    	} else {
    		node1 = l2; node2 = l1;
    	}
    	head = node1;
    	
    	//add two list to node1
    	while (node1 != null && node2 != null) {
    		int value = node1.val + node2.val;
    		if (value > 9) {
    			if (node1.next == null) {
    				node1.next = new ListNode(1);
    			} else {
    				node1.next.val += 1;
    			}
    			node1.val = value % 10;
    		} else {
    			node1.val = value;
    		}
    		node1 = node1.next;
    		node2 = node2.next;
    	}
    	
    	//if there are nodes in node1 that are bigger than 9, we need handle that
    	node1 = head;
    	while (node1 != null) {
    		if (node1.val > 9) {
    			if (node1.next == null) {
    				node1.next = new ListNode(1);
    			} else {
    				node1.next.val += 1;
    			}
    			node1.val = node1.val % 10;
        	}
    		node1 = node1.next;
    	}
    	
        return head;
    }

	private int count(ListNode l1) {
		int sum = 0;
		while (l1 != null) {
			++sum;
			l1 = l1.next;
		}
		return sum;
	}
}
