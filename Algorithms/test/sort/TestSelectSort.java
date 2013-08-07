package sort;

public class TestSelectSort extends TestTemplate {

	@Override
	protected ISort getSortObject() {
		return new SelectSort();
	}

	@Override
	protected String getSortName() {
		return "select sort";
	}

}
