package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class BestTimetoBuyandSellStockTest {

	@Test
	public void test() {
		BestTimetoBuyandSellStock b = new BestTimetoBuyandSellStock();
		assertEquals(b.maxProfit(new int[]{1, 2}), 1);
		assertEquals(b.maxProfit(new int[]{1, 2, 1}), 1);
		assertEquals(b.maxProfit(new int[]{1, 2, 3}), 2);
	}

}
