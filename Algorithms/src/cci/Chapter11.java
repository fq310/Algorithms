package cci;

/*
 * Sorting and Searching
 */
public class Chapter11 {

	//11.1
	public void mergeArray(int[] a, int[] b) {
		int indexA = a.length - b.length - 1;
		int indexB = b.length - 1;
		int indexInsert = a.length - 1;
		while (indexA >= 0 && indexB >= 0 && indexInsert >= 0) {
			if (a[indexA] > b[indexB]) {
				a[indexInsert] = a[indexA];
				--indexA;
			} else {
				a[indexInsert] = b[indexB];
				--indexB;
			}
			--indexInsert;
		}
		while (indexB >= 0 && indexInsert >= 0) {
			a[indexInsert] = b[indexB];
			--indexB;
			--indexInsert;
		}
	}

}
