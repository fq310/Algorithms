package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestValidParenthesesTest {

	@Test
	public void test() {
		LongestValidParentheses l = new LongestValidParentheses();
		assertEquals(l.longestValidParentheses("(()"), 2);
		assertEquals(l.longestValidParentheses(")()())"), 4);
		assertEquals(l.longestValidParentheses("()(()"), 2);
		assertEquals(l.longestValidParentheses("()(())"), 6);
	}

}
