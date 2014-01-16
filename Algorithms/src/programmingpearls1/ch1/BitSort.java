package programmingpearls1.ch1;

import java.util.List;

public class BitSort {
	public static List<Integer> sort(List<Integer> data, int size) {
		BitArray bitArray = new BitArray(size);
		for (Integer value : data) {
			bitArray.addData(value);
		}
		return bitArray.toList();
	}
}
