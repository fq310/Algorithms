package sort;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public abstract class TestTemplate {
	
	@Test
	public void test() {
		executeTest();
	}
	
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

	private void compare(int[] sortedCase, int[] targetCase) {
		if (sortedCase.length != targetCase.length) fail(getSortName() + ": sorted data length is not equal to the target data.");
		for (int i = 0; i < sortedCase.length; ++i) {
			Assert.assertArrayEquals(getSortName() + " failed. Sorted case :" + getArrayString(sortedCase) +
					" Target Data: " + getArrayString(targetCase), sortedCase, targetCase);
		}
	}
	
	private String getArrayString (int[] testCase) {
		StringBuilder result = new StringBuilder();
		result.append("[ ");
		for (int i : testCase) {
			result.append(i).append(" ");
		}
		result.append("]");
		return result.toString();
	}

	abstract protected ISort getSortObject();
	abstract protected String getSortName();
}
