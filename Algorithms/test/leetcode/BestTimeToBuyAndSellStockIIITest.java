package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class BestTimeToBuyAndSellStockIIITest {

	@Test
	public void test() {
		BestTimeToBuyAndSellStockIII b = new BestTimeToBuyAndSellStockIII();
		assertEquals(b.maxProfit(new int[]{2,1,2,1,0,0,1}), 2);
		assertEquals(b.maxProfit(new int[]{1, 2}), 1);
		assertEquals(b.maxProfit(new int[]{2, 1}), 0);
		assertEquals(b.maxProfit(new int[]{1, 2, 1}), 1);
		assertEquals(b.maxProfit(new int[]{1, 2, 3}), 2);
		assertEquals(b.maxProfit(new int[]{1, 2, 3, 1, 2, 3}), 4);
		assertEquals(b.maxProfit(new int[]{1, 2, 3, 1, 2, 4}), 5);
		assertEquals(b.maxProfit(new int[]{2, 3, 1, 1}), 1);
		assertEquals(b.maxProfit(new int[]{2, 3, 1, 4}), 4);
		assertEquals(b.maxProfit(new int[]{2, 3, 2, 4}), 3);
		assertEquals(b.maxProfit(new int[]{1, 2, 1, 2, 1, 2}), 2);
		
		assertEquals(b.maxProfit(new int[]{7, 6, 5, 4, 1, 5}), 4);
		assertEquals(b.maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}), 13);
	}

}
