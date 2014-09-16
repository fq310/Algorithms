package leetcode_20;

import java.util.ArrayList;
import java.util.List;

import leetcode_30.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
    	if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
        	list.add(node);
        	node = node.next;
        }
        int n = list.size() - 1;
        int i = 0;
        List<ListNode> newList = new ArrayList<>();
        while (i < n - i) {
        	newList.add(list.get(i));
        	newList.add(list.get(n - i));
        	++i;
        }
        if (i == n - i) newList.add(list.get(i));
        for (int j = 0; j < newList.size() - 1; ++j) {
        	newList.get(j).next = newList.get(j + 1);
        }
        newList.get(newList.size() - 1).next = null;
    }
}
