package leetcode_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
    	Map<Character, Character> map = new HashMap<>();
    	map.put('(', ')');
    	map.put('[', ']');
    	map.put('{', '}');
    	Stack<Character> stack = new Stack<>();
    	for (int i = 0; i < s.length(); ++i) {
    		char c = s.charAt(i);
    		if (stack.isEmpty()) {
    			stack.push(c);
    			continue;
    		}
			Character oppositeTopChar = map.get(stack.peek());
			if (oppositeTopChar != null && oppositeTopChar == c) {
    			stack.pop();
    		} else {
    			stack.push(c);
    		}
    	}
    	if (stack.isEmpty()) return true;
        return false;
    }
}
