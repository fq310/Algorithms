package sort;

public class BubbleSort implements ISort {

	@Override
	public void sort(int[] data) {
		for (int i = 0; i < data.length; ++i) {
			for (int j = data.length - 1; j > i; --j) {
				if (data[j] < data[j - 1]) {
					int temp = data[j - 1];
					data[j - 1] = data[j];
					data[j] = temp;
				}
			}
		}
	}

}
