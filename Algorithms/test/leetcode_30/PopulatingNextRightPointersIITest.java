package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.PopulatingNextRightPointersII;
import leetcode_30.TreeLinkNode;

import org.junit.Test;

public class PopulatingNextRightPointersIITest {

	@Test
	public void test() {
		PopulatingNextRightPointersII p = new PopulatingNextRightPointersII();
		TreeLinkNode root = new TreeLinkNode(0);
		p.connect(root);
		assertEquals(root.next, null);
		addChild(root);
		p.connect(root);
		assertEquals(root.left.next, root.right);
		addChild(root.left);
		root.right.right = new TreeLinkNode(7);
		p.connect(root);
		assertEquals(root.left.left.next, root.left.right);
		assertEquals(root.left.right.next, root.right.right);
	}

	private void addChild(TreeLinkNode root) {
		TreeLinkNode node1 = new TreeLinkNode(root.val + 1);
		TreeLinkNode node2 = new TreeLinkNode(root.val + 2);
		root.left = node1;
		root.right = node2;		
	}

}
