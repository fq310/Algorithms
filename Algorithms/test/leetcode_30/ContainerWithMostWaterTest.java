package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContainerWithMostWaterTest {

	@Test
	public void test() {
		ContainerWithMostWater c = new ContainerWithMostWater();
		assertEquals(c.maxArea(new int[]{2,3,4,3,2,3}), 12);
		assertEquals(c.maxArea(new int[]{10,9,8,7,6,5,4,3,2,1}), 25);
	}

}
