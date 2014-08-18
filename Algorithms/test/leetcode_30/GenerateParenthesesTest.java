package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenerateParenthesesTest {

	@Test
	public void test() {
		GenerateParentheses g = new GenerateParentheses();
		assertEquals(g.generateParenthesis(1).toString(), "[()]");
		assertEquals(g.generateParenthesis(2).toString(), "[()(), (())]");
		assertEquals(g.generateParenthesis(3).toString(), "[((())), ()(()), ()()(), (()()), (())()]");
		}

}
