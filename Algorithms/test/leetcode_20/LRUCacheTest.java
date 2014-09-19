package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class LRUCacheTest {

	@Test
	public void test() {
		LRUCache l = new LRUCache(2);
		l.set(2, 1);
		l.set(1, 1);
		assertEquals(l.get(2), 1);
		l.set(4, 1);
		assertEquals(l.get(1), -1);
		assertEquals(l.get(2), 1);
	}

}
