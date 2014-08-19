package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeNumberTest {

	@Test
	public void test() {
		PalindromeNumber p = new PalindromeNumber();
		assertEquals(p.isPalindrome(12), false);
		assertEquals(p.isPalindrome(22), true);
		assertEquals(p.isPalindrome(121), true);
	}

}
