package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class InterleavingStringTest {

	@Test
	public void test() {
		InterleavingString i = new InterleavingString();
		assertEquals(i.isInterleave("ab", "c", "abc"), true);
		assertEquals(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"), true);
		assertEquals(i.isInterleave("aabcc", "dbbca", "aadbbbaccc"), false);
		assertEquals(i.isInterleave("abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb", "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc", "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc"), true);
	}
}
