package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanToIntegerTest {

	@Test
	public void test() {
		RomanToInteger r = new RomanToInteger();
		assertEquals(r.romanToInt("MCMIV"), 1904);
		assertEquals(r.romanToInt("CM"), 900);
		assertEquals(r.romanToInt("IV"), 4);
		assertEquals(r.romanToInt("CD"), 400);
		assertEquals(r.romanToInt("XC"), 90);
		assertEquals(r.romanToInt("XL"), 40);
		assertEquals(r.romanToInt("IX"), 9);
		assertEquals(r.romanToInt("MLXVI"), 1066);
	}

}
