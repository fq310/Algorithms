package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class CandyTest {

	@Test
	public void test() {
		Candy c = new Candy();
		assertEquals(c.candy(new int[]{1}), 1);
		assertEquals(c.candy(new int[]{1, 1}), 2);
		assertEquals(c.candy(new int[]{1, 0}), 3);
		assertEquals(c.candy(new int[]{0, 1}), 3);
		
		assertEquals(c.candy(new int[]{1, 0, 2}), 5);
		assertEquals(c.candy(new int[]{1, 1, 1}), 3);
		assertEquals(c.candy(new int[]{1, 2, 2}), 4);
		assertEquals(c.candy(new int[]{1, 2, 1}), 4);
		assertEquals(c.candy(new int[]{3, 2, 1}), 6);
		assertEquals(c.candy(new int[]{1, 2, 3}), 6);
		
		assertEquals(c.candy(new int[]{1, 1, 1, 1}), 4);
		
		assertEquals(c.candy(new int[]{4, 3, 3, 2, 1}), 9);
		
		assertEquals(c.candy(new int[]{58,21,72,77,48,9,38}), 13);
		
		assertEquals(c.candy(new int[]{5,1,1,1,10,2,1,1,1,3}), 15);
	}

}
