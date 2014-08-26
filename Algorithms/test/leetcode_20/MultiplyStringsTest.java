package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplyStringsTest {

	@Test
	public void test() {
		MultiplyStrings m = new MultiplyStrings();
		assertEquals(m.multiply("123", "45"), "5535");
		assertEquals(m.multiply("123", "456"), "56088");
		assertEquals(m.multiply("1", "1"), "1");
		assertEquals(m.multiply("2", "3"), "6");
		assertEquals(m.multiply("2", "7"), "14");
		assertEquals(m.multiply("20", "7"), "140");
		assertEquals(m.multiply("2", "70"), "140");
		assertEquals(m.multiply("0", "0"), "0");
		assertEquals(m.multiply("707", "3"), "2121");
	}

}
