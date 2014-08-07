package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.BestTimetoBuyandSellStock;

import org.junit.Test;

public class BestTimetoBuyandSellStockTest {

	@Test
	public void test() {
		BestTimetoBuyandSellStock b = new BestTimetoBuyandSellStock();
		assertEquals(b.maxProfit(new int[]{1, 2}), 1);
		assertEquals(b.maxProfit(new int[]{1, 2, 1}), 1);
		assertEquals(b.maxProfit(new int[]{1, 2, 3}), 2);
		assertEquals(b.maxProfit(new int[]{1, 2, 3, 1, 2, 3}), 2);
		assertEquals(b.maxProfit(new int[]{1, 2, 3, 1, 2, 4}), 3);
		assertEquals(b.maxProfit(new int[]{2, 3, 1, 1}), 1);
		assertEquals(b.maxProfit(new int[]{2, 3, 1, 4}), 3);
		assertEquals(b.maxProfit(new int[]{2, 3, 2, 4}), 2);
	}

}
