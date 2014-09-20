package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextJustificationTest {

	@Test
	public void test() {
		TextJustification t = new TextJustification();
		assertEquals(t.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16).toString(), "[This    is    an, example  of text, justification.  ]");
		assertEquals(t.fullJustify(new String[]{""}, 0).toString(), "[]");
		assertEquals(t.fullJustify(new String[]{"What","must","be","shall","be."}, 12).toString(), "[What must be, shall be.   ]");
	}

}
