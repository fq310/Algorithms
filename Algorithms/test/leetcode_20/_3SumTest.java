package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class _3SumTest {

	@Test
	public void test() {
		_3Sum s = new _3Sum();
		assertEquals(s.threeSum(new int[]{-1,0,1,2,-1,-4}).toString(), "[[-1, -1, 2], [-1, 0, 1]]");
	}

}
