package leetcode_30;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
    	List<String> result = new LinkedList<>();
    	result.add("()");
    	for (int i = 1; i < n; ++i) {
    		Set<String> buffer = new HashSet<>();
    		for (int j = 0; j < result.size(); ++j) {
    			String str = result.get(j);
    			for (int k = 0; k < str.length(); ++k) {
    					buffer.add(str.substring(0, k) + "()" + str.substring(k, str.length()));
    			}
    		}
    		result.clear();
    		result.addAll(buffer);
    	}
        return result;
    }
}
