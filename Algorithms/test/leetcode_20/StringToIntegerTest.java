package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringToIntegerTest {

	@Test
	public void test() {
		StringToInteger s = new StringToInteger();
		assertEquals(s.atoi("+1"), 1);
		assertEquals(s.atoi("-1"), -1);
		assertEquals(s.atoi("-+1"), 0);
		assertEquals(s.atoi("+-2"), 0);
		assertEquals(s.atoi("0"), 0);
		assertEquals(s.atoi("      -11919730356x"), -2147483648);
		assertEquals(s.atoi("2147483648"), 2147483647);
		assertEquals(s.atoi("2147483647"), 2147483647);
		assertEquals(s.atoi("2147483646"), 2147483646);
		assertEquals(s.atoi("-2147483649"), -2147483648);
		assertEquals(s.atoi("-2147483648"), -2147483648);
		assertEquals(s.atoi("-2147483647"), -2147483647);
	}

}
