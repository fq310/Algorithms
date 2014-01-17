package programmingpearls1.ch2;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class TestAnagram {
	@Test
	public void testAnagram() {
		Anagram a = new Anagram();
		List<String> words = new ArrayList<>();
		words.add("pots");
		words.add("stop");
		words.add("tops");
		words.add("bat");
		words.add("take");
		List<List<String>> result = a.findAnagram(words);
		Assert.assertTrue(result.size() == 1);
		result.get(0);
	}
}
