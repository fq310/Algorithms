package sort;

import static org.junit.Assert.fail;

import org.junit.Assert;

public abstract class TestTemplate {
	protected void executeTest() {
		TestData testData = new TestData();
		int[][] unSortedData = testData.getUnsortedData();
		int[][] sortedData = testData.getSortedDatas();
		ISort sortObject = getSortObject();
		
		for (int i = 0; i < unSortedData.length; ++i) {
			int[] testCase = unSortedData[i];
			sortObject.sort(testCase);
			int[] sortedCase = sortedData[i];
			compare(testCase, sortedCase);
		}
		
	}

	private void compare(int[] testCase, int[] sortedCase) {
		if (testCase.length != sortedCase.length) fail(getSortName() + ": sorted data length is not equal to the target data.");
		for (int i = 0; i < testCase.length; ++i) {
			Assert.assertArrayEquals(getSortName() + ": test case " + i + " failed. " +
					"sorted: " + testCase[i] + 
					" . Target: " + sortedCase[i], testCase, sortedCase);
		}
	}

	abstract protected ISort getSortObject();
	abstract protected String getSortName();
}
