package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlusOneTest {

	@Test
	public void test() {
		PlusOne p = new PlusOne();
		assertArrayEquals(p.plusOne(new int[]{9,9,9}), new int[]{1,0,0,0});
		assertArrayEquals(p.plusOne(new int[]{9,9,8}), new int[]{9,9,9});
	}

}
