package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivideTwoIntegersTest {

	@Test
	public void test() {
		DivideTwoIntegers d = new DivideTwoIntegers();
		assertEquals(d.divide(1, 2), 0);
		assertEquals(d.divide(1, 1), 1);
		assertEquals(d.divide(-2, 1), -2);
		assertEquals(d.divide(3, -2), -1);
		assertEquals(d.divide(-4, -2), 2);
		assertEquals(d.divide(2147483647, 1), 2147483647);
	}

}
