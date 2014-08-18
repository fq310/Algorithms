package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaximumSubarrayTest {

	@Test
	public void test() {
		MaximumSubarray m = new MaximumSubarray();
		assertEquals(m.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6);
	}

}
