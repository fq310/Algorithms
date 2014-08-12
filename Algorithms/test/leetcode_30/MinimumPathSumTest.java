package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumPathSumTest {

	@Test
	public void test() {
		MinimumPathSum m = new MinimumPathSum();
		int[][] data = new int[][]{{1,2,3},{1,2,3}};
		assertEquals(m.minPathSum(data), 7);
	}

}
