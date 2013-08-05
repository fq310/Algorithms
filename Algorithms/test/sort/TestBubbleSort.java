package sort;

import org.junit.Test;

public class TestBubbleSort extends TestTemplate {
	
	@Test
	public void test() {
		super.executeTest();
	}

	@Override
	protected ISort getSortObject() {
		return new BubbleSort();
	}

	@Override
	protected String getSortName() {
		return "bubble sort";
	}

}
