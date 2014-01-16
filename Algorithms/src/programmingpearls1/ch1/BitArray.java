package programmingpearls1.ch1;

import java.util.ArrayList;
import java.util.List;

public class BitArray {
	private int[] data;
	/**
	 * Represent numbers between [0, i - 1]
	 * exclude i
	 * @param size
	 */
	public BitArray(int size) {
		int count = size / 32;
		int remainder = size % 32;
		if (remainder > 0) ++count;
		data = new int[count];
	}

	public void addData(int target) {
		int remainder = target % 32;
		int newValue = 0x00000001;
		for (int i = 0; i < remainder; ++i) {
			newValue = newValue << 1;
		}
		
		int location = target / 32;
		data[location] = data[location] | newValue;
		
	}
	
	public int[] getData() {
		return data;
	}

	public String toDataString() {
		StringBuilder result = new StringBuilder();
		for (int i : data) {
			result.append(i);
		}
		return result.toString();
	}
	
	public List<Integer> toList() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < data.length; ++i) {
			int value = data[i];
			int mask = 0x00000001;
			for (int j = 0; j < 32; ++j) {
				boolean isNumber = ((value & mask) == mask);
				if (isNumber) {
					result.add(i * 32 + j);
				}
				mask = mask << 1;
			}
		}
		return result;
	}

}
 