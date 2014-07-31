package leetcode;

/*
 * �Ľ��ķ������Ƕ�̬�滮�ˣ��Ǿ��ǵ�һ��ɨ�裬�ȼ����������[0,...,i]�е����������һ�����鱣����������ôʱ����O(n)��
 * �ڶ���������ɨ�裬����������[i,...,n-1]�ϵ����������Ȼ��O(n)
 * ��������㷨�ĸ��ӶȾ���O(n)�ġ�
 * ע������������ʱ�򣬼��㷽��ҲҪ��֮����������סmaxIndex�ˣ�������minIndex
 * ����ٺϲ�һ�¼�������
 * profitsBackWord[0]�ǵ�������ģ���Ϊ����ʵ��profitsForward[prices.length]�ǵȼ۵ġ�
 * ����ѭ���ﶼû�д���������Ҫ��������һ�¡�
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
