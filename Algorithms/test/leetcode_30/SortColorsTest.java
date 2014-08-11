package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortColorsTest {

	@Test
	public void test() {
		SortColors s = new SortColors();
		int[] a = new int[]{1};
		s.sortColors(a);
		assertArrayEquals(a, new int[]{1});
		
		a = new int[]{2, 1, 0};
		s.sortColors(a);
		assertArrayEquals(a, new int[]{0, 1, 2});
		
		a = new int[]{2, 2, 1, 1, 0};
		s.sortColors(a);
		assertArrayEquals(a, new int[]{0, 1, 1, 2, 2});
	}

}
