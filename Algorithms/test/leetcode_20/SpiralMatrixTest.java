package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpiralMatrixTest {

	@Test
	public void test() {
		SpiralMatrix s = new SpiralMatrix();
		assertEquals(s.spiralOrder(new int[][]{{1}}).toString(), "[1]");
		assertEquals(s.spiralOrder(new int[][]{{2, 3}}).toString(), "[2, 3]");
		assertEquals(s.spiralOrder(new int[][]{{1,2},{4,3}}).toString(), "[1, 2, 3, 4]");
		assertEquals(s.spiralOrder(new int[][]{{2,5,8},{4,0,-1}}).toString(), "[2, 5, 8, -1, 0, 4]");
		assertEquals(s.spiralOrder(new int[][]{{1,2,3},{8,9,4},{7,6,5}}).toString(), "[1, 2, 3, 4, 5, 6, 7, 8, 9]");
		assertEquals(s.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}).toString(), "[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]");
	}

}
