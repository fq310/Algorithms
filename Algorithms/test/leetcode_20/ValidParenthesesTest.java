package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidParenthesesTest {

	@Test
	public void test() {
		ValidParentheses v = new ValidParentheses();
		assertEquals(v.isValid("()"), true);
		assertEquals(v.isValid("()[]{}"), true);
		assertEquals(v.isValid("(]"), false);
		assertEquals(v.isValid("([)]"), false);
	}

}
