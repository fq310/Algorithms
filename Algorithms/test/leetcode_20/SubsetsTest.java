package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubsetsTest {

	@Test
	public void test() {
		Subsets s = new Subsets();
		assertEquals(s.subsets(new int[]{1, 2, 3}).toString(), "[[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]");
	}

}
