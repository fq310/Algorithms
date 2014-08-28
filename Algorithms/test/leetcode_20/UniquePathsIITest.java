package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniquePathsIITest {

	@Test
	public void test() {
		UniquePathsII u = new UniquePathsII();
		assertEquals(u.uniquePathsWithObstacles(new int[][]{{0}}), 1);
		assertEquals(u.uniquePathsWithObstacles(new int[][]{{1}}), 0);
		assertEquals(u.uniquePathsWithObstacles(new int[][]{{0, 1}}), 0);
		assertEquals(u.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}), 2);
		assertEquals(u.uniquePathsWithObstacles(new int[][]{{0,0,0},{1,1,0},{0,0,0}}), 1);
		assertEquals(u.uniquePathsWithObstacles(new int[][]{{0,0,0},{1,1,1},{0,0,0}}), 0);
		assertEquals(u.uniquePathsWithObstacles(new int[][]{{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0}, {0,0,0,0,0}}), 0);
	}

}
