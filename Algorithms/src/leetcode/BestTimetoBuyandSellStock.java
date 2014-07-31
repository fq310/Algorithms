package leetcode;

/*
 * 从头遍历，如果某一点低于最小点，这一点就应该作为新的最小点计算
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
    	int minIndex = 0;
    	int profit = 0;
    	for (int i = 1; i < prices.length; ++i) {
    		if (prices[i] - prices[minIndex] > profit) {
    			profit = prices[i] - prices[minIndex];
    		}
    		if (prices[i] < prices[minIndex]) {
    			minIndex = i;
    		}
    	}
        return profit;
    }
}
