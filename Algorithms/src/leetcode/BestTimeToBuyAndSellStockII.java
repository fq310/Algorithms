package leetcode;

/*
 * 点在于，每条上升路径算作一次成功的盈利，一旦路径下降，就把那个点作为新的min起点
 * 这样计算出的极润是最大的
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length < 2) return 0;
    	int minIndex = 0;
    	int maxIndex = 0;
    	int profit = 0;
    	while (maxIndex < prices.length - 1) {
    		while ((maxIndex < prices.length - 1) &&
    				(prices[maxIndex] < prices[maxIndex + 1])) {
    			++maxIndex;
    		}
    		if (prices[maxIndex] - prices[minIndex] > 0)
    			profit += prices[maxIndex] - prices[minIndex];
    		++maxIndex;
    		minIndex = maxIndex;
    	}
        return profit;
    }
    
  //某人的变态解法
    public int maxProfit2(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;
    }
}
