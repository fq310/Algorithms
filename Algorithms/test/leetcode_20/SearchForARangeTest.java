package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchForARangeTest {

	@Test
	public void test() {
		SearchForARange s = new SearchForARange();
		int[] A = new int []{5, 7, 7, 8, 8, 10};
		assertArrayEquals(s.searchRange(A, 8), new int[]{3, 4});
		assertArrayEquals(s.searchRange(A, 7), new int[]{1, 2});
		assertArrayEquals(s.searchRange(A, 5), new int[]{0, 0});
		assertArrayEquals(s.searchRange(A, 10), new int[]{5, 5});
		assertArrayEquals(s.searchRange(A, 3), new int[]{-1, -1});
	}

}
