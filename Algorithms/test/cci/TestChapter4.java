package cci;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestChapter4 {
	@Test
	public void testInOrderTraversal() {
		Chapter4 ch4 = new Chapter4();
		BNode tree = createBST(new int[]{1,2,3,4,5,6,7,8,9,10});
		List<BNode> nodeList = new ArrayList<BNode>();
		ch4.preOrderTraversal(tree, nodeList);
		Assert.assertEquals(nodeList.toString(), "[5, 2, 1, 3, 4, 8, 6, 7, 9, 10]");
		nodeList.clear();
		ch4.preOrder(tree, nodeList);
		Assert.assertEquals(nodeList.toString(), "[5, 2, 1, 3, 4, 8, 6, 7, 9, 10]");
		nodeList.clear();
		ch4.inOrderTraversal(tree, nodeList);
		Assert.assertEquals(nodeList.toString(), "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
		nodeList.clear();
		ch4.inOrder(tree, nodeList);
		Assert.assertEquals(nodeList.toString(), "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
		nodeList.clear();
		ch4.postOrderTraversal(tree, nodeList);
		Assert.assertEquals(nodeList.toString(), "[1, 4, 3, 2, 7, 6, 10, 9, 8, 5]");
		
		tree = createBST(new int[]{});
		nodeList = new ArrayList<BNode>();
		ch4.preOrderTraversal(tree, nodeList);
		Assert.assertEquals(nodeList.toString(), "[]");
	}
	
	private BNode createBST(int[] data) {
		return createBST(data, 0, data.length - 1);
	}

	private BNode createBST(int[] data, int start, int end) {
		if (start > end) return null;
		int mid = (start + end) / 2;
		BNode node = new BNode(data[mid]);
		node.left = createBST(data, start, mid - 1);
		node.right = createBST(data, mid + 1, end);
		return node;
	}
}



