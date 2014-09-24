package leetcode_20;

import leetcode_30.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return create(preorder, inorder, 0, 0, inorder.length - 1);
    }

	private TreeNode create(int[] preorder, int[] inorder, int root, int inLeft, int inRight) {
		if (inLeft > inRight) return null;
		if (inLeft == inRight) return new TreeNode(inorder[inRight]);
		TreeNode node = new TreeNode(preorder[root]);
		int inOrderRootIndex = inLeft;
		for (; inOrderRootIndex <= inRight; ++inOrderRootIndex) {
			if (inorder[inOrderRootIndex] == node.val) {
				break;
			}
		}
		node.left = create(preorder, inorder, root + 1, inLeft, inOrderRootIndex - 1);
		node.right = create(preorder, inorder, root + (inOrderRootIndex - inLeft) + 1, inOrderRootIndex + 1, inRight);
		return node;
	}
}
