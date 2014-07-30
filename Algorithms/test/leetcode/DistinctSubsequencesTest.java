package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class DistinctSubsequencesTest {

	@Test
	public void test() {
		assertEquals(test("a", "a"), 1);
		assertEquals(test("a", "b"), 0);
		assertEquals(test("a", ""), 1);
		assertEquals(test("", "a"), 0);
		
		assertEquals(test("aa", "a"), 2);
		assertEquals(test("ab", "a"), 1);
		assertEquals(test("aa", "aa"), 1);
		
		assertEquals(test("aacaacca", "ca"), 1);
		
		assertEquals(test("rabbbit", "rabbit"), 3);
		assertEquals(test("rrabbbit", "rabbit"), 6);
	}
	
	private int test(String s, String t) {
		DistinctSubsequences ds = new DistinctSubsequences();
		return ds.numDistinct(s, t);
	}

}
