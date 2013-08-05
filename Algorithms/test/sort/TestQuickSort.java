package sort;

import org.junit.Test;

public class TestQuickSort extends TestTemplate {
	
	@Test
	public void test() {
		super.executeTest();
	}

	@Override
	protected ISort getSortObject() {
		return new QuickSort();
	}

	@Override
	protected String getSortName() {
		return "quick sort";
	}

}
