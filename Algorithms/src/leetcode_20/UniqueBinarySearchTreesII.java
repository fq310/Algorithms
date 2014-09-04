package leetcode_20;

import java.util.ArrayList;
import java.util.List;

import leetcode_30.TreeNode;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }
    private List<TreeNode> dfs(int start,int end){
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
        	result.add(null);
        	return result;
        }
        for (int i = start; i <= end; ++i) {
        	List<TreeNode> leftNodes = dfs(start, i - 1);
        	List<TreeNode> rightNodes = dfs(i + 1, end);
        	for (TreeNode left : leftNodes) {
        		for (TreeNode right : rightNodes) {
        			TreeNode node = new TreeNode(i);
        			node.left = left;
        			node.right = right;
        			result.add(node);
        		}
        	}
        }
        return result;
    }
}
