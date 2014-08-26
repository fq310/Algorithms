package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class JumpGameTest {

	@Test
	public void test() {
		JumpGame j = new JumpGame();
		assertEquals(j.canJump(new int[]{2,3,1,1,4}), true);
		assertEquals(j.canJump(new int[]{2,0,0}), true);
		assertEquals(j.canJump(new int[]{3,2,1,0,4}), false);
	}

}
