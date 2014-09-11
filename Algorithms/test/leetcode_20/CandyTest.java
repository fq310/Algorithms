package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class CandyTest {

	@Test
	public void test() {
		Candy c = new Candy();
		assertEquals(c.candy(new int[]{1, 0, 2}), 5);
		assertEquals(c.candy(new int[]{1, 1}), 2);
		assertEquals(c.candy(new int[]{1, 0}), 3);
		assertEquals(c.candy(new int[]{0, 1}), 3);
		assertEquals(c.candy(new int[]{1, 1, 1}), 3);
		assertEquals(c.candy(new int[]{1, 1, 1, 1}), 4);
		assertEquals(c.candy(new int[]{1}), 1);
		assertEquals(c.candy(new int[]{1, 2, 2}), 4);
	}

}
