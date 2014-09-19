package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class _4SumTest {

	@Test
	public void test() {
		_4Sum s = new _4Sum();
		s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
		s.fourSum(new int[]{2, 1, 0, -1}, 2);
	}

}
