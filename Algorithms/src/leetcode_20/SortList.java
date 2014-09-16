package leetcode_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leetcode_30.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
    	if (head == null) return head;
    	ListNode node = head;
    	List<ListNode> list = new ArrayList<>();
    	while (node != null) {
    		list.add(node);
    		node = node.next;
    	}
    	Collections.sort(list, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val) return -1;
				if (o1.val > o2.val) return 1;
				return 0;
			}
    	});
    	for (int i = 0; i < list.size() - 1; ++i) {
    		list.get(i).next = list.get(i + 1);
    	}
    	list.get(list.size() - 1).next = null;
        return list.get(0);
    }
}
