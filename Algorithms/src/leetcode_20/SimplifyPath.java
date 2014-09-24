package leetcode_20;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
    	Stack<String> stack = new Stack<>();
    	String[] operators = path.split("/");
    	for (String operator : operators) {
    		if (operator.length() == 0) continue;
    		switch (operator) {
    		case "." :
    			break;
    		case ".." :
    			if (stack.size() > 0)
    				stack.pop();
    			break;
    		default:
    			stack.push(operator);
    		}
    	}
    	StringBuilder result = new StringBuilder();
    	while (!stack.isEmpty()) {
    		String operator = stack.pop();
    		result.insert(0, operator).insert(0, "/");
    	}
    	if (result.length() == 0) result.append("/");
        return result.toString();
    }
}
