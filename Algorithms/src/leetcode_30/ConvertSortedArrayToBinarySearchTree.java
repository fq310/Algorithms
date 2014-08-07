package leetcode_30;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        return createNode(num, 0, num.length - 1);
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
