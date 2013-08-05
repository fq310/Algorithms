package sort;

public class QuickSort implements ISort {

	@Override
	public void sort(int[] data) {
		quickSort(data, 0, data.length - 1);
	}
	
	private void quickSort(int[] data, int start, int end) {
		if (start > end) return;
		int middleIndex = partition(data, start, end);
		quickSort(data, start, middleIndex - 1);
		quickSort(data, middleIndex + 1, end);
	}

	private int partition(int[] data, int start, int end) {
		int middleValue = data[start];
		while (start < end) {
			while (start < end && data[end] >= middleValue) {
				--end;
			}
			data[start] = data[end];
			while (start < end && data[start] <= middleValue) {
				++start;
			}
			data[end] = data[start];
		}
		data[end] = middleValue;
		return end;
	}

}
