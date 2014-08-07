package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.PascalsTriangleII;

import org.junit.Test;

public class PascalsTriangleIITest {

	@Test
	public void test() {
		PascalsTriangleII p = new PascalsTriangleII();
		assertEquals(p.getRow(0).toString(), "[1]");
		assertEquals(p.getRow(1).toString(), "[1, 1]");
		assertEquals(p.getRow(2).toString(), "[1, 2, 1]");
		assertEquals(p.getRow(4).toString(), "[1, 4, 6, 4, 1]");
	}

}
