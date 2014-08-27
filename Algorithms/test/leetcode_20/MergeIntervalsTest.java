package leetcode_20;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MergeIntervalsTest {

	@Test
	public void test() {
		MergeIntervals m = new MergeIntervals();
		assertEquals(m.merge(getList(new int[]{1, 3, 2, 6, 8, 10, 15, 18})), getList(new int[]{1, 6, 8, 10, 15, 18}));
		assertEquals(m.merge(getList(new int[]{1, 3, 2, 6, 5, 8, 7, 10})), getList(new int[]{1, 10}));
		assertEquals(m.merge(getList(new int[]{1, 4, 0, 4})), getList(new int[]{0, 4}));
		assertEquals(m.merge(getList(new int[]{1, 4, 0, 0})), getList(new int[]{0, 0, 1, 4}));
		assertEquals(m.merge(getList(new int[]{2, 3, 4, 5, 6, 7, 1, 10})), getList(new int[]{1, 10}));
	}
	

	private List<Interval> getList(int[] data) {
		List<Interval> list = new ArrayList<>();
		for (int i = 0; i < data.length - 1; ++i) {
			Interval in = new Interval();
			in.start = data[i];
			in.end = data[i + 1];
			list.add(in);
			++i;
		}
		return list;
	}

}
