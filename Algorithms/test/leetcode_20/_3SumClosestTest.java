package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class _3SumClosestTest {

	@Test
	public void test() {
		_3SumClosest s = new _3SumClosest();
		assertEquals(s.threeSumClosest(new int[]{-1, 2, 1, 4}, 1), 2);
	}

}
