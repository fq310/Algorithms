package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.GrayCode;

import org.junit.Test;

public class GrayCodeTest {

	@Test
	public void test() {
		GrayCode g = new GrayCode();
		assertEquals(g.grayCode(2).toString(), "[0, 1, 3, 2]");
	}

}
