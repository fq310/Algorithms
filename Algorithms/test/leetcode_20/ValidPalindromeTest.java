package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidPalindromeTest {

	@Test
	public void test() {
		ValidPalindrome v = new ValidPalindrome();
		assertEquals(v.isPalindrome("A man, a plan, a canal: Panama"), true);
		assertEquals(v.isPalindrome("race a car"), false);
	}

}
