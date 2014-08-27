package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class LengthOfLastWordTest {

	@Test
	public void test() {
		LengthOfLastWord l = new LengthOfLastWord();
		assertEquals(l.lengthOfLastWord("Hello World"), 5);
		assertEquals(l.lengthOfLastWord(""), 0);
		assertEquals(l.lengthOfLastWord(" "), 0);
	}

}
