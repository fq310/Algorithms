package leetcode_20;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
    	if (tokens == null || tokens.length == 0) return 0;
    	if (tokens.length == 1 && Character.isDigit(tokens[0].charAt(tokens[0].length() - 1))) {
    		return Integer.parseInt(tokens[0]);
    	}
    	Stack<String> stack = new Stack<>();
    	int result = 0;
    	for (String token : tokens) {
    		if (Character.isDigit(token.charAt(token.length() - 1))) {
    			stack.push(token);
    		} else {
    			int token2 = Integer.parseInt(stack.pop());
    			int token1 = Integer.parseInt(stack.pop());
    			switch (token) {
    			case "+" :
    				result = (token1 + token2);
    				break;
    			case "-" :
    				result = (token1 - token2);
    				break;
    			case "*" :
    				result = (token1 * token2);
    				break;
    			case "/" :
    				result = (token1 / token2);
    			}
    			stack.push(String.valueOf(result));
    		}
    	}
        return result;
    }
}
