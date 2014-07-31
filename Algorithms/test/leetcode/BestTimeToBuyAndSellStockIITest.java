package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class BestTimeToBuyAndSellStockIITest {

	@Test
	public void test() {
		BestTimeToBuyAndSellStockII b = new BestTimeToBuyAndSellStockII();
		assertEquals(b.maxProfit(new int[]{1, 2}), 1);
		assertEquals(b.maxProfit(new int[]{1, 2, 1}), 1);
		assertEquals(b.maxProfit(new int[]{1, 2, 3}), 2);
		assertEquals(b.maxProfit(new int[]{1, 2, 3, 1, 2, 3}), 4);
		assertEquals(b.maxProfit(new int[]{1, 2, 3, 1, 2, 4}), 5);
		assertEquals(b.maxProfit(new int[]{2, 3, 1, 1}), 1);
		assertEquals(b.maxProfit(new int[]{2, 3, 1, 4}), 4);
		assertEquals(b.maxProfit(new int[]{2, 3, 2, 4}), 3);
		
		assertEquals(b.maxProfit(new int[]{7, 6, 5, 4, 1, 5}), 4);
	}

}
