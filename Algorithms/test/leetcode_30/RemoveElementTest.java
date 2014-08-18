package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveElementTest {

	@Test
	public void test() {
		RemoveElement r = new RemoveElement();
		assertEquals(r.removeElement(new int[]{1, 2, 3, 1, 3, 4, 1, 1}, 1), 4);
		assertEquals(r.removeElement(new int[]{}, 0), 0);
	}

}
