package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows == 0) return result;
		List<Integer> row0 = new ArrayList<>();
		row0.add(1);
		result.add(row0);
		for (int i = 1; i < numRows; ++i) {
			List<Integer> rowI = new ArrayList<>();
			for (int j = 0; j <= i; ++j) {
				int elementJ = getValueFromUpperRow(result.get(i - 1), j - 1, j);
				rowI.add(elementJ);
			}
			result.add(rowI);
		}
        return result;
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
}
