package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromePartitioningIITest {

	@Test
	public void test() {
		PalindromePartitioningII p = new PalindromePartitioningII();
		assertEquals(p.minCut("aab"), 1);
		assertEquals(p.minCut("ababababababababababababcbabababababababababababa"), 1);
	}

}
