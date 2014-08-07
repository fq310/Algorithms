package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.PascalsTriangle;

import org.junit.Test;

public class PascalsTriangleTest {

	@Test
	public void test() {
		PascalsTriangle p = new PascalsTriangle();
		assertEquals(p.generate(0).toString(), "[]");
		assertEquals(p.generate(1).toString(), "[[1]]");
		assertEquals(p.generate(2).toString(), "[[1], [1, 1]]");
		assertEquals(p.generate(3).toString(), "[[1], [1, 1], [1, 2, 1]]");
		assertEquals(p.generate(5).toString(), "[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]");
	}

}
