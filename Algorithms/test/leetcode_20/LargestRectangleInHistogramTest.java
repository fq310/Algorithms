package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargestRectangleInHistogramTest {

	@Test
	public void test() {
		LargestRectangleInHistogram l = new LargestRectangleInHistogram();
		assertEquals(l.largestRectangleArea(new int[]{6, 2, 5, 4, 5, 1, 6}), 12);
		assertEquals(l.largestRectangleArea(new int[]{6, 5, 4, 3, 2, 1}), 12);
	}

}
