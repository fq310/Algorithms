package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class PermutationsIITest {

	@Test
	public void test() {
		PermutationsII p = new PermutationsII();
		assertEquals(p.permuteUnique(new int[]{1,1,2}).toString(), "[[1, 1, 2], [1, 2, 1], [2, 1, 1]]");
	}

}
