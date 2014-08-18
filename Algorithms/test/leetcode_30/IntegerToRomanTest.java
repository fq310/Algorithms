package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerToRomanTest {

	@Test
	public void test() {
		IntegerToRoman i = new IntegerToRoman();
		assertEquals(i.intToRoman(1904), "MCMIV");
		assertEquals(i.intToRoman(900), "CM");
		assertEquals(i.intToRoman(4), "IV");
		assertEquals(i.intToRoman(400), "CD");
		assertEquals(i.intToRoman(90), "XC");
		assertEquals(i.intToRoman(40), "XL");
		assertEquals(i.intToRoman(9), "IX");
		assertEquals(i.intToRoman(1066), "MLXVI");
	}

}
