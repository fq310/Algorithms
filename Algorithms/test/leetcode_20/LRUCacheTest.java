package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class LRUCacheTest {

	@Test
	public void test() {
		LRUCache l = new LRUCache(3);
		l.set(1, 1);
		l.set(2, 2);
		l.set(3,3);
		l.set(4,4);
		l.set(5,5);
		l.set(6,6);
		
		l.set(4,44);
		l.set(7,7);
	}

}
