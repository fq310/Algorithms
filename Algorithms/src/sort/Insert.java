package sort;

public class Insert implements ISort{

	@Override
	public void sort(int[] data) {
		for (int i = 1; i < data.length; ++i) {
			int currentData = data[i];
			if (currentData >= data[i - 1]) continue;
			int j = i - 1;
			for (; currentData < data[j]; --j) {
				data[j] = data[j + 1];
			}
			data[j + 1] = currentData;
		}
	}
	
}
