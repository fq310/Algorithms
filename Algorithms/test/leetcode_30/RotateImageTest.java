package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateImageTest {

	@Test
	public void test() {
		RotateImage r = new RotateImage();
		int[][] matrix = new int[][]{{1}};
		r.rotate(matrix);
		assertArrayEquals(matrix, new int[][]{{1}});
		
		matrix = new int[][]{{1,2}, {3,4}};
		r.rotate(matrix);
		assertArrayEquals(matrix, new int[][]{{3, 1}, {4, 2}});
		
		matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
		r.rotate(matrix);
		assertArrayEquals(matrix, new int[][]{{7,4,1},{8,5,2},{9,6,3}});
	}

}
