package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegularExpressionMatchingTest {

	@Test
	public void test() {
		RegularExpressionMatching r = new RegularExpressionMatching();
		assertEquals(r.isMatch("aa", "a"), false);
		assertEquals(r.isMatch("aa", "aa"), true);
		assertEquals(r.isMatch("aaa", "aa"), false);
		assertEquals(r.isMatch("aa", "a*"), true);
		assertEquals(r.isMatch("aa", ".*"), true);
		assertEquals(r.isMatch("ab", ".*"), true);
		assertEquals(r.isMatch("aab", "c*a*b"), true);
	}

}
