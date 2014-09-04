package leetcode_20;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void test() {
		Triangle t = new Triangle();
		assertEquals(t.minimumTotal(craeteList(new int[][]{{-1},{2, 3},{1, -1, -3}})), -1);
		assertEquals(t.minimumTotal(craeteList(new int[][]{{-1},{2, 3}})), 1);
		assertEquals(t.minimumTotal(craeteList(new int[][]{{-1}})), -1);
	}
	
	private List<List<Integer>> craeteList(int[][] data) {
		List<List<Integer>> result = new ArrayList<>();
		for (int[] i : data) {
			List<Integer> row = new ArrayList<>();
			for (int j : i) {
				row.add(j);
			}
			result.add(row);
		}
		return result;
	}

}
