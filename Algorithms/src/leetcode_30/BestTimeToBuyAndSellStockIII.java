package leetcode_30;

/*
 * 改进的方法就是动态规划了，那就是第一步扫描，先计算出子序列[0,...,i]中的最大利润，用一个数组保存下来，那么时间是O(n)。
 * 第二步是逆向扫描，计算子序列[i,...,n-1]上的最大利润，依然是O(n)
 * 所以最后算法的复杂度就是O(n)的。
 * 注意在逆向计算的时候，计算方法也要随之反过来，记住maxIndex了，而不是minIndex
 * 最后再合并一下计算结果。
 * profitsBackWord[0]是单独处理的，因为他其实和profitsForward[prices.length]是等价的。
 * 但是循环里都没有处理到。所以要单独处理一下。
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length < 2) return 0;
    	int minIndex = 0;
    	int[] profitsForward = new int[prices.length];
    	profitsForward[0] = 0;
    	int maxProfit = 0;
    	for (int i = 1; i < prices.length; ++i) {
    		int profit = prices[i] - prices[minIndex];
    		if (profit > maxProfit) maxProfit = profit;
    		profitsForward[i] = maxProfit;
    		if (prices[i] < prices[minIndex]) minIndex = i;
    	}
    	
    	maxProfit = 0;
    	int[] profitsBackWord = new int[prices.length];
    	int maxIndex = prices.length - 1;
    	for (int i = prices.length - 1; i >= 0; --i) {
    		int profit = prices[maxIndex] - prices[i];
    		if (profit > maxProfit) maxProfit = profit;
    		profitsBackWord[i] = maxProfit;
    		if (prices[maxIndex] < prices[i]) maxIndex = i;
    	}
    	
    	maxProfit = 0;
    	for (int i = 1; i < prices.length - 1; ++i) {
    		int profit = profitsForward[i] + profitsBackWord[i + 1];
    		if (profit > maxProfit) maxProfit = profit;
    	}
    	if (profitsBackWord[0] > maxProfit) maxProfit = profitsBackWord[0];
    	
    	return maxProfit;
    }
}
