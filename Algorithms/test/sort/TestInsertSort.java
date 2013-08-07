package sort;

public class TestInsertSort extends TestTemplate{

	@Override
	protected ISort getSortObject() {
		return new InsertSort();
	}

	@Override
	protected String getSortName() {
		return "Insert Sort";
	}

}
