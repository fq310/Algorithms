package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	
    public List<Integer> grayCode(int n) {
    	List<Integer> result = new ArrayList<>();
    	List<List<String>> resultString = new ArrayList<>();
    	List<String> code0 = new ArrayList<>();
    	code0.add("0");
    	resultString.add(code0);
    	List<String> code1 = new ArrayList<>();
    	code1.add("0");
    	code1.add("1");
    	resultString.add(code1);
    	for (int i = 2; i <= n; ++i) {
    		List<String> codeList = new ArrayList<>();
    		List<String> preCode = resultString.get(i - 1);
			for (String str : preCode) {
    			codeList.add("0" + str);
    		}
    		for (int j = preCode.size() - 1; j >= 0; --j) {
    			codeList.add("1" + preCode.get(j));
    		}
    		resultString.add(codeList);
    	}
    	for (String str : resultString.get(n)) {
    		result.add(Integer.parseInt(str, 2));
    	}
        return result;
    }

}
