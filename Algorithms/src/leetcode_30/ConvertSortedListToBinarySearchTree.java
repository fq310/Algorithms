package leetcode_30;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
    	List<Integer> nodes = new ArrayList<>();
        while (head != null) {
        	nodes.add(head.val);
        	head = head.next;
        }
        int[] array = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); ++i) {
        	array[i] = nodes.get(i);
        }
        return createNode(array, 0, array.length - 1);
    }
    
    private TreeNode createNode(int[] num, int start, int end) {
    	if (start > end) return null;
    	if (start == end) return new TreeNode(num[start]);
    	int mid = (start + end) / 2;
    	TreeNode parent = new TreeNode(num[mid]);
    	parent.left = createNode(num, start, mid - 1);
    	parent.right = createNode(num, mid + 1, end);
    	return parent;
    	
    }
}
