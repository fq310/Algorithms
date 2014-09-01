package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaximalRectangleTest {

	@Test
	public void test() {
		MaximalRectangle m = new MaximalRectangle();
		char[][] matrix = new char[][]{{'0', '1', '1'}, {'1', '1', '1'}, {'1', '1', '1'}};
		assertEquals(m.maximalRectangle(matrix), 6);
		matrix = new char[][]{{'1', '1', '1'}, {'1', '1', '1'}, {'1', '1', '1'}};
		assertEquals(m.maximalRectangle(matrix), 9);
		matrix = new char[][]{{'0', '1'}, {'1', '0'}};
		assertEquals(m.maximalRectangle(matrix), 1);
	}

}
