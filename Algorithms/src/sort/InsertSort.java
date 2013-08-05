package sort;

public class InsertSort implements ISort{

	@Override
	public void sort(int[] data) {
		for (int i = 1; i < data.length; ++i) {
			int currentData = data[i];
			if (currentData >= data[i - 1]) continue;
			int j = i - 1;
			for (; j >=0 && data[j] > currentData; --j) {
				data[j + 1] = data[j];
			}
			data[j + 1] = currentData;
		}
	}
	
}
