package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubstringWithConcatenationOfAllWordsTest {

	@Test
	public void test() {
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		assertEquals(s.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}).toString(), "[0, 9]");
		
		s = new SubstringWithConcatenationOfAllWords();
		assertEquals(s.findSubstring("a", new String[]{"a"}).toString(), "[0]");
		
		s = new SubstringWithConcatenationOfAllWords();
		assertEquals(s.findSubstring("aaa", new String[]{"a", "a"}).toString(), "[0, 1]");
		s = new SubstringWithConcatenationOfAllWords();
		assertEquals(s.findSubstring("aaa", new String[]{"a", "b"}).toString(), "[]");
	}

}
