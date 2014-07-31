package leetcode;

/*
 * �����ڣ�ÿ������·������һ�γɹ���ӯ����һ��·���½����Ͱ��Ǹ�����Ϊ�µ�min���
 * ����������ļ���������
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
    
  //ĳ�˵ı�̬�ⷨ
    public int maxProfit2(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;
    }
}
