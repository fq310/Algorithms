package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonPrefixTest {

	@Test
	public void test() {
		LongestCommonPrefix l = new LongestCommonPrefix();
		assertEquals(l.longestCommonPrefix(new String[]{"abc", "ab", "a"}), "a");
		assertEquals(l.longestCommonPrefix(new String[]{"", "", ""}), "");
		assertEquals(l.longestCommonPrefix(new String[]{"a", "", ""}), "");
		assertEquals(l.longestCommonPrefix(new String[]{"a", "b", "c"}), "");
		assertEquals(l.longestCommonPrefix(new String[]{"aabc", "aab", "aa"}), "aa");
		assertEquals(l.longestCommonPrefix(new String[]{"aabc", "aab"}), "aab");
	}

}
