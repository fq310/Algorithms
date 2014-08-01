package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 假设row的编号从0开始！
 * row0有一个元素，即[1]
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
    	List<List<Integer>> result = new ArrayList<>();
		List<Integer> row0 = new ArrayList<>();
		row0.add(1);
		result.add(row0);
		for (int i = 1; i <= rowIndex; ++i) {
			List<Integer> rowI = new ArrayList<>();
			for (int j = 0; j <= i; ++j) {
				int elementJ = getValueFromUpperRow(result.get(i - 1), j - 1, j);
				rowI.add(elementJ);
			}
			result.add(rowI);
		}
        return result.get(rowIndex);
    }
    
	private int getValueFromUpperRow(List<Integer> list, int i, int j) {
		int sum = 0;
		if (0 <= i && i < list.size()) {
			sum += list.get(i);
		}
		if (0 <= j && j < list.size()) {
			sum += list.get(j);
		}
		return sum;
	}
	
	//下面是一个数组的解法，空间复杂度为O(k)
	//初始化一个大小为k + 1的数组，因为k行有k+1个元素
	//先把第一个元素置为1
	public List<Integer> getRow2(int rowIndex) {
    	List<Integer> result = new ArrayList<>(rowIndex);
    	int[] resultArray = new int[rowIndex + 1];
    	resultArray[0] = 1;
    	for (int i = 1; i < resultArray.length; ++i) {
    		for (int j = i; j >= 1; --j) {
    			resultArray[j] += resultArray[j - 1];
    		}
    	}
    	for (int i : resultArray) {
    		result.add(i);
    	}
        return result;
    }
}
