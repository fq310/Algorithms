package sort;


public class TestBubbleSort extends TestTemplate {
	
	@Override
	protected ISort getSortObject() {
		return new BubbleSort();
	}

	@Override
	protected String getSortName() {
		return "bubble sort";
	}

}
