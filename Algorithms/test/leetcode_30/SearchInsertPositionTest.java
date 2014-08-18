package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchInsertPositionTest {

	@Test
	public void test() {
		SearchInsertPosition s = new SearchInsertPosition();
		assertEquals(s.searchInsert(new int[]{1,3,5,6}, 5), 2);
		assertEquals(s.searchInsert(new int[]{1,3,5,6}, 2), 1);
		assertEquals(s.searchInsert(new int[]{1,3,5,6}, 7), 4);
		assertEquals(s.searchInsert(new int[]{1,3,5,6}, 0), 0);
	}

}
