package leetcode_20;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class WordBreakTest {

	@Test
	public void test() {
		WordBreak w = new WordBreak();
		Set<String> dict = new HashSet<>();
		dict.add("leet"); dict.add("code");
		assertEquals(w.wordBreak("leetcode", dict), true);
		
		dict = new HashSet<>();
		dict.add("leet");
		assertEquals(w.wordBreak("leetcode", dict), false);
		
		dict = new HashSet<>();
		dict.add("a");dict.add("b");dict.add("bbb");dict.add("bbbb");
		assertEquals(w.wordBreak("bb", dict), true);
	}

}
