package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueBinarySearchTreesTest {

	@Test
	public void test() {
		UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
		assertEquals(u.numTrees(0), 1);
		assertEquals(u.numTrees(1), 1);
		assertEquals(u.numTrees(2), 2);
		assertEquals(u.numTrees(3), 5);
	}

}
