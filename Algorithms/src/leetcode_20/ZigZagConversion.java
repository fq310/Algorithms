package leetcode_20;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
    	if (nRows < 2) return s;
    	List<List<String>> result = initialResultList(nRows);
    	int increment = 1;
    	int row = 0;
    	for (int i = 0; i < s.length(); ++i) {
    		String currentChar = String.valueOf(s.charAt(i));
    		result.get(row).add(currentChar);
    		row += increment;
    		if (row == nRows) {
    			row -= 2;
    			increment = -1;
    		} else if (row == -1) {
    			row += 2;
    			increment = 1;
    		}
    	}
        return getResultString(result).toString();
    }

	private StringBuilder getResultString(List<List<String>> result) {
		StringBuilder newString = new StringBuilder();
    	for (List<String> list : result) {
    		for (String str : list) {
    			newString.append(str);
    		}
    	}
		return newString;
	}

	private List<List<String>> initialResultList(int nRows) {
		List<List<String>> result = new ArrayList<>();
    	for (int i = 0; i < nRows; ++i) {
    		result.add(new ArrayList<String>());
    	}
		return result;
	}
}
