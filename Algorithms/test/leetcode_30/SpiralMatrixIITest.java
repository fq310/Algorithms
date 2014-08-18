package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpiralMatrixIITest {

	@Test
	public void test() {
		SpiralMatrixII s = new SpiralMatrixII();
		assertArrayEquals(s.generateMatrix(1), new int[][]{{1}});
		assertArrayEquals(s.generateMatrix(2), new int[][]{{1,2},{4,3}});
		assertArrayEquals(s.generateMatrix(3), new int[][]{{1,2,3},{8,9,4},{7,6,5}});
	}

}
