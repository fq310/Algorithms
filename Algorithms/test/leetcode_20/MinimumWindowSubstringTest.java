package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumWindowSubstringTest {

	@Test
	public void test() {
		MinimumWindowSubstring s = new MinimumWindowSubstring();
		assertEquals(s.minWindow("ADOBECODEBANC", "ABC"), "BANC");
		assertEquals(s.minWindow("a", "b"), "");
		assertEquals(s.minWindow("a", "a"), "a");
		assertEquals(s.minWindow("a", "aa"), "");
		assertEquals(s.minWindow("bba", "ab"), "ba");
		assertEquals(s.minWindow("bdab", "ab"), "ab");
		}

}
