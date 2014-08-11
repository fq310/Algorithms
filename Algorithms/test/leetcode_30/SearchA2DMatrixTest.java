package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchA2DMatrixTest {

	@Test
	public void test() {
		int a[][] = new int[][]{{1,   3,  5,  7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		SearchA2DMatrix s = new SearchA2DMatrix();
		assertEquals(s.searchMatrix(a, 1), true);
		assertEquals(s.searchMatrix(a, 3), true);
		assertEquals(s.searchMatrix(a, 7), true);
		assertEquals(s.searchMatrix(a, 10), true);
		assertEquals(s.searchMatrix(a, 50), true);
		assertEquals(s.searchMatrix(a, 34), true);
		
		assertEquals(s.searchMatrix(a, -1), false);
		assertEquals(s.searchMatrix(a, 8), false);
		assertEquals(s.searchMatrix(a, 22), false);
		assertEquals(s.searchMatrix(a, 54), false);
		assertEquals(s.searchMatrix(a, 4), false);
		assertEquals(s.searchMatrix(a, 12), false);
		assertEquals(s.searchMatrix(a, 40), false);
	}

}
