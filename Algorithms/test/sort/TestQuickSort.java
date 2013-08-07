package sort;

public class TestQuickSort extends TestTemplate {
	
	@Override
	protected ISort getSortObject() {
		return new QuickSort();
	}

	@Override
	protected String getSortName() {
		return "quick sort";
	}

}
