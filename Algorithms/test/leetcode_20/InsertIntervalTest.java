package leetcode_20;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class InsertIntervalTest {

	@Test
	public void test() {
		InsertInterval i = new InsertInterval();
		Interval in = new Interval();
		in.start = 4;
		in.end = 9;
		assertEquals(i.insert(getList(new int[]{1, 2, 3, 5, 6, 7, 8, 10, 12, 16}), in), getList(new int[]{1, 2, 3, 10, 12, 16}));
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
