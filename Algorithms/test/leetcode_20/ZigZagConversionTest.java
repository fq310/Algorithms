package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZigZagConversionTest {

	@Test
	public void test() {
		ZigZagConversion z = new ZigZagConversion();
		assertEquals(z.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
	}

}
