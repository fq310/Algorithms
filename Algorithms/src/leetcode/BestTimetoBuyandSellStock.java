package leetcode;

/*
 * ��ͷ���������ĳһ�������С�㣬��һ���Ӧ����Ϊ�µ���С�����
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
