package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class SetMatrixZeroesTest {

	@Test
	public void test() {
		int a[][] = new int[][]{{1,   3,  5,  7}, {10, 0, 16, 20}, {23, 30, 34, 50}};
		SetMatrixZeroes s = new SetMatrixZeroes();
		s.setZeroes(a);
		assertArrayEquals(a, new int[][]{{1,   0,  5,  7}, {0, 0, 0, 0}, {23, 0, 34, 50}});
	}

}
