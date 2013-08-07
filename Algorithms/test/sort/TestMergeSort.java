package sort;

public class TestMergeSort extends TestTemplate {

	@Override
	protected ISort getSortObject() {
		return new MergeSort();
	}

	@Override
	protected String getSortName() {
		return "merge sort";
	}

}
