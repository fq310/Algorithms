package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class EditDistanceTest {

	@Test
	public void test() {
		EditDistance e = new EditDistance();
		assertEquals(e.minDistance("ab", "a"), 1);
		assertEquals(e.minDistance("abc", "abc"), 0);
	}

}
