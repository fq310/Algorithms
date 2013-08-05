package sort;

import org.junit.Test;

public class TestInsertSort extends TestTemplate{

	@Test
	public void test() {
		super.executeTest();
	}

	@Override
	protected ISort getSortObject() {
		return new InsertSort();
	}

	@Override
	protected String getSortName() {
		return "Insert Sort";
	}

}
