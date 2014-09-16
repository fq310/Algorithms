package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxPointsOnALineTest {

	@Test
	public void test() {
		MaxPointsOnALine m = new MaxPointsOnALine();
		Point[] p = new Point[]{new Point(0, 0), new Point(0, 0)};
		assertEquals(m.maxPoints(p), 2);
		
		p = new Point[]{new Point(0, 0),  new Point(1, 1), new Point(0, 0)};
		assertEquals(m.maxPoints(p), 3);
	}

}
