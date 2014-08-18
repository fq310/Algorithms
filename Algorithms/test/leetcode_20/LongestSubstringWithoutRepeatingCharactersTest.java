package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {

	@Test
	public void test() {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		assertEquals(l.lengthOfLongestSubstring("abcabcbb"), 3);
		assertEquals(l.lengthOfLongestSubstring("bbbbb"), 1);
		assertEquals(l.lengthOfLongestSubstring("bbbbbabc"), 3);
		assertEquals(l.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"), 12);
	}

}
