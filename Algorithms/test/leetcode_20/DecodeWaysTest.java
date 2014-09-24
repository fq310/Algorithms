package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecodeWaysTest {

	@Test
	public void test() {
		DecodeWays d = new DecodeWays();
		assertEquals(d.numDecodings("12"), 2);
		assertEquals(d.numDecodings("10"), 1);
		assertEquals(d.numDecodings("01"), 0);
	}

}
