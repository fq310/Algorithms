package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimplifyPathTest {

	@Test
	public void test() {
		SimplifyPath s = new SimplifyPath();
		assertEquals(s.simplifyPath("/home/"), "/home");
		assertEquals(s.simplifyPath("/a/./b/../../c/"), "/c");
		assertEquals(s.simplifyPath("/../"), "/");
		assertEquals(s.simplifyPath("/home//foo/"), "/home/foo");
	}

}
