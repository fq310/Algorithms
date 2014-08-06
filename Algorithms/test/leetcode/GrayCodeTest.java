package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrayCodeTest {

	@Test
	public void test() {
		GrayCode g = new GrayCode();
		assertEquals(g.grayCode(2).toString(), "[0, 1, 3, 2]");
	}

}
