package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvaluateReversePolishNotationTest {

	@Test
	public void test() {
		EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
		assertEquals(e.evalRPN(new String[]{"3","-4","+"}), -1);
		assertEquals(e.evalRPN(new String[]{"2", "1", "+", "3", "*"}), 9);
		assertEquals(e.evalRPN(new String[]{"4", "13", "5", "/", "+"}), 6);
	}

}
