package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class CombinationsTest {

	@Test
	public void test() {
		Combinations c = new Combinations();
		assertEquals(c.combine(4, 1).toString(), "[[1], [2], [3], [4]]");
		assertEquals(c.combine(4, 2).toString(), "[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]");
		assertEquals(c.combine(4, 3).toString(), "[[1, 2, 3], [1, 2, 4], [1, 3, 4], [2, 3, 4]]");
		assertEquals(c.combine(4, 4).toString(), "[[1, 2, 3, 4]]");
	}

}
