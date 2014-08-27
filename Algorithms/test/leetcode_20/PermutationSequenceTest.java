package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class PermutationSequenceTest {

	@Test
	public void test() {
		PermutationSequence p = new PermutationSequence();
		assertEquals(p.getPermutation(1, 1), "1");
		assertEquals(p.getPermutation(2, 2), "21");
		assertEquals(p.getPermutation(3, 6), "321");
		assertEquals(p.getPermutation(4, 6), "1432");
		assertEquals(p.getPermutation(8, 38790), "85721643");
	}

}
