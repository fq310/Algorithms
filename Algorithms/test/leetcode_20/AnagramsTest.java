package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramsTest {

	@Test
	public void test() {
		Anagrams a = new Anagrams();
		assertEquals(a.anagrams(new String[]{"dog","cat","god","tac"}).toString(), "[dog, god, cat, tac]");
	}

}
