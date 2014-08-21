package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidSudokuTest {

	@Test
	public void test() {
		ValidSudoku v = new ValidSudoku();
		char[][] data = getCharArray(".87654321,2........,3........,4........,5........,6........,7........,8........,9........");
		assertEquals(v.isValidSudoku(data), true);
		data = getCharArray("....5..1.,.4.3.....,.....3..1,8......2.,..2.7....,.15......,.....2...,.2.9.....,..4......");
		assertEquals(v.isValidSudoku(data), false);
	}
	
	private char[][] getCharArray(String data) {
		char[][] array = new char[9][];
		String[] rows = data.split(",");
		for (int i = 0; i < rows.length; ++i) {
			String row = rows[i];
			array[i] = new char[rows.length];
			for (int j = 0; j < row.length(); ++j) {
				array[i][j] = row.charAt(j);
			}
		}
		return array;
	}

}
