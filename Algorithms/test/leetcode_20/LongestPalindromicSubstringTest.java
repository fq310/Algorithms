package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestPalindromicSubstringTest {

	@Test
	public void test() {
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		assertEquals(l.longestPalindrome("a"), "a");
		assertEquals(l.longestPalindrome("aa"), "aa");
		assertEquals(l.longestPalindrome("aca"), "aca");
		assertEquals(l.longestPalindrome("abcba"), "abcba");
		assertEquals(l.longestPalindrome("abacdfgdcaba"), "abcba");
	}
}
