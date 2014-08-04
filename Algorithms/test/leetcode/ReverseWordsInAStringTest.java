package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseWordsInAStringTest {

	@Test
	public void test() {
		ReverseWordsInAString s = new ReverseWordsInAString();
		assertEquals(s.reverseWords(""), "");
		assertEquals(s.reverseWords(" "), "");
		assertEquals(s.reverseWords("1"), "1");
		assertEquals(s.reverseWords(" 1 "), "1");
		assertEquals(s.reverseWords("1 2"), "2 1");
		assertEquals(s.reverseWords(" 1 2 "), "2 1");
		assertEquals(s.reverseWords("1 2 3"), "3 2 1");
		assertEquals(s.reverseWords(" 1 2 3 "), "3 2 1");
		assertEquals(s.reverseWords(" 1   2   3 "), "3 2 1");
	}

}
