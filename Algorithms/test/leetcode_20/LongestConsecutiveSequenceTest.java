package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestConsecutiveSequenceTest {

	@Test
	public void test() {
		LongestConsecutiveSequence l = new LongestConsecutiveSequence();
		assertEquals(l.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}), 4);
		assertEquals(l.longestConsecutive(new int[]{2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645}), 3);
	}

}
