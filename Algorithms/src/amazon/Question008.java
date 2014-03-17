package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question008 {

	public static void main(String[] args) {
		System.out.println(getMaxScore(new int[]{1, 2, 1, 2}, new int[]{1, 2}));
		System.out.println(getMaxScore(new int[]{1, 2, 1, 2, 1}, new int[]{1, 2, 1}));
	}
	
	private static int getMaxScore(int[] grid, int[] cards) {
		Set<List<Integer>> allPath = new HashSet<List<Integer>>();
		List<Integer> cardList = new ArrayList<Integer>();
		for (int i : cards) {
			cardList.add(i);
		}
		getAllPath(cardList, new ArrayList<Integer>(), cardList.size(), allPath);
		int maxSum = 0;
		for (List<Integer> path : allPath) {
			int sum = 0;
			int index = 0;
			for (int card : path) {
				sum += grid[index + card];
				index += card;
			}
			sum += cardList.get(0);
			if (sum > maxSum) maxSum = sum;
		}
		return maxSum;
	}
	
    private static void getAllPath(List<Integer> datas, List<Integer> bufferList, int num, Set<List<Integer>> result) {   
        if (bufferList.size() == num) {   
        	result.add(bufferList);
            return;   
        }   
        for (int i = 0; i < datas.size(); i++) {   
            List<Integer> newDatas = new ArrayList<Integer>(datas);   
            List<Integer> newTarget = new ArrayList<Integer>(bufferList);   
            newTarget.add(newDatas.get(i));   
            newDatas.remove(i);   
            getAllPath(newDatas, newTarget, num, result);   
        }   
    }  
	
	

}
