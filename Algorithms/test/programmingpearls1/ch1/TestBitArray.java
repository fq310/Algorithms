package programmingpearls1.ch1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestBitArray {
	private int SIZE = 34;
	@Before
	public void initial() {
	}
	
	@Test
	public void test1_2() {
		BitArray bit = new BitArray(SIZE);
		bit.addData(32);
		Assert.assertEquals(bit.toDataString(), "01");

		bit = new BitArray(SIZE);
		bit.addData(0);
		Assert.assertEquals(bit.toDataString(), "10");
		
		bit = new BitArray(SIZE);
		bit.addData(31);
		Assert.assertEquals(bit.toDataString(), "-21474836480");
		
		
		bit = new BitArray(SIZE);
		bit.addData(30);
		Assert.assertEquals(bit.toDataString(), "10737418240");
		bit.addData(22);
		Assert.assertEquals(bit.toDataString(), "10779361280");
		bit.addData(1);
		Assert.assertEquals(bit.toDataString(), "10779361300");
		bit.addData(7);
		Assert.assertEquals(bit.toDataString(), "10779362580");
		bit.addData(33);
		Assert.assertEquals(bit.toDataString(), "10779362582");
	}
	
	@Test
	public void test1_3() {
		sortOnRandomDistinctIntegers(1);
		sortOnRandomDistinctIntegers(10);
		sortOnRandomDistinctIntegers(1000);
		sortOnRandomDistinctIntegers(10000);
		sortOnRandomDistinctIntegers(100000);
	}

	//random integer range: [0, size - 1]
	private void sortOnRandomDistinctIntegers(int size) {
		List<Integer> data = getRandomDistinctInteger(size);
		List<Integer> result = BitSort.sort(data, size);
		int resultSize = result.size();
		for (int i = 0; i < resultSize; ++i) {
			if (i + 1 < resultSize) {
				Assert.assertTrue(result.get(i).intValue() == (result.get(i + 1).intValue() - 1));
			}
		}
	}

	//random integer range: [0, size - 1]
	private List<Integer> getRandomDistinctInteger(int size) {
		Set<Integer> valueSet = new HashSet<>();
		List<Integer> data = new LinkedList<>();
		while (valueSet.size() < size) {
			int value = (int) (Math.random() * size);
			if (valueSet.contains(value)) continue;
			valueSet.add(value);
			data.add(value);
		}
		return data;
	}
}
