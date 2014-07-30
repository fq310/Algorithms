package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseIntegerTest {

	@Test
	public void test() {
		ReverseInteger r = new ReverseInteger();
		assertEquals(r.reverse(0), 0);
		assertEquals(r.reverse(1), 1);
		assertEquals(r.reverse(11), 11);
		assertEquals(r.reverse(12), 21);
		assertEquals(r.reverse(111), 111);
		assertEquals(r.reverse(100), 1);
		assertEquals(r.reverse(123), 321);
		assertEquals(r.reverse(-123), -321);
	}

}
