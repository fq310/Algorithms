package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromePartitioningTest {

	@Test
	public void test() {
		PalindromePartitioning p = new PalindromePartitioning();
		assertEquals(p.partition("aab").toString(), "[[a, a, b], [aa, b]]");
	}

}
