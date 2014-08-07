package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.GasStation;

import org.junit.Test;

public class GasStationTest {
	@Test
	public void test() {
		assertEquals(test(new int[]{4}, new int[]{4}), 0);
		assertEquals(test(new int[]{4}, new int[]{3}), 0);
		assertEquals(test(new int[]{2}, new int[]{3}), -1);
		
		assertEquals(test(new int[]{2, 3}, new int[]{3, 2}), 1);
		assertEquals(test(new int[]{2, 3}, new int[]{2, 3}), 0);
		assertEquals(test(new int[]{2, 3}, new int[]{4, 2}), -1);
		assertEquals(test(new int[]{4, 4}, new int[]{5, 3}), 1);
		assertEquals(test(new int[]{4, 4}, new int[]{4, 4}), 0);
		
		assertEquals(test(new int[]{2, 3, 1}, new int[]{3, 1, 2}), 1);
		
		assertEquals(test(new int[]{4, 6, 2, 4}, new int[]{4, 3, 2, 4}), 0);
	}
	
	private int test(int[] gas, int[] cost) {
		GasStation gs = new GasStation();
		return gs.canCompleteCircuit(gas, cost);
	}
}
