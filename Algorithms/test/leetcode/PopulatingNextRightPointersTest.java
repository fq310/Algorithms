package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

public class PopulatingNextRightPointersTest {

	@Test
	public void test() {
		PopulatingNextRightPointers p = new PopulatingNextRightPointers();
		TreeLinkNode root = new TreeLinkNode(0);
		p.connect(root);
		assertEquals(root.next, null);
		addChild(root);
		p.connect(root);
		assertEquals(root.left.next, root.right);
		addChild(root.left);
		addChild(root.right);
		p.connect(root);
		assertEquals(root.left.left.next, root.left.right);
		assertEquals(root.right.left.next, root.right.right);
		assertEquals(root.left.right.next, root.right.left);
	}

	private void addChild(TreeLinkNode root) {
		TreeLinkNode node1 = new TreeLinkNode(root.val + 1);
		TreeLinkNode node2 = new TreeLinkNode(root.val + 2);
		root.left = node1;
		root.right = node2;		
	}

}
