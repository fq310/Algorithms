package sort;

public class MergeSort implements ISort {

	@Override
	public void sort(int[] data) {
		int[] sortedData = new int[data.length];
		mergeSort(data, sortedData, 0, data.length - 1);
	}

	private void mergeSort(int[] data, int[] sortedData, int start, int end) {
		if (start == end) return;
		int middle = (start + end) / 2;
		mergeSort(data, sortedData, start, middle);
		mergeSort(data, sortedData, middle + 1, end);
		merge(data, sortedData, start, middle, middle + 1, end);
	}

	private void merge(int[] data, int[] sortedData, int start1, int end1,
			int start2, int end2) {
		int oldStart = start1;
		int sortedIndex = start1;
		while (start1 <= end1 && start2 <= end2) {
			if (data[start1] < data[start2]) {
				sortedData[sortedIndex++] = data[start1++];
			} else {
				sortedData[sortedIndex++] = data[start2++];
			}
		}
		while (start1 <= end1) {
			sortedData[sortedIndex++] = data[start1++];
		}
		while (start2 <= end2) {
			sortedData[sortedIndex++] = data[start2++];
		}
		
		while (oldStart <= end2) {
			data[oldStart] = sortedData[oldStart];
			++oldStart;
		}
	}

}
