package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidNumberTest {

	@Test
	public void test() {
		ValidNumber v = new ValidNumber();
		assertEquals(v.isNumber("0"), true);
		assertEquals(v.isNumber(" 0.1"), true);
		assertEquals(v.isNumber("abc"), false);
		assertEquals(v.isNumber("1 a"), false);
		assertEquals(v.isNumber("2e10"), true);
		assertEquals(v.isNumber(".1"), true);
		assertEquals(v.isNumber("3."), true);
		assertEquals(v.isNumber("46.e3"), true);
		assertEquals(v.isNumber(".2e81"), true);
	}

}
