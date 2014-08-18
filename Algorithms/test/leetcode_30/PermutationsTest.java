package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class PermutationsTest {

	@Test
	public void test() {
		Permutations p = new Permutations();
		assertEquals(p.permute(new int[]{1,2,3}).toString(), "[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]");
//		assertEquals(p.permute(new int[]{0,-1,1}).toString(), "[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]");
	}

}
