package leetcode_20;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SurroundedRegionsTest {

	@Test
	public void test() {
		SurroundedRegions s = new SurroundedRegions();
		char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		s.solve(board);
		assertArrayEquals(board, new char[][]{{'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'},{'X','O','X','X'}});
		
		board = new char[][]{{'X', 'X', 'X'}, {'X', 'O', 'X'}, {'X', 'X', 'X'}};
		s.solve(board);
		assertArrayEquals(board, new char[][]{{'X', 'X', 'X'}, {'X', 'X', 'X'}, {'X', 'X', 'X'}});
		
		board = getBoard(new String[]{"OXOOOOOOO","OOOXOOOOX","OXOXOOOOX","OOOOXOOOO","XOOOOOOOX","XXOOXOXOX","OOOXOOOOO","OOOXOOOOO","OOOOOXXOO"});
		s.solve(board);
		assertArrayEquals(board, getBoard(new String[]{"OXOOOOOOO","OOOXOOOOX","OXOXOOOOX","OOOOXOOOO","XOOOOOOOX","XXOOXOXOX","OOOXOOOOO","OOOXOOOOO","OOOOOXXOO"}));
		
		board = new char[][]{{'O'}};
		s.solve(board);
		assertArrayEquals(board, new char[][]{{'O'}});
	}
	
	private char[][] getBoard(String[] data) {
		char[][] result = new char[data.length][];
		for (int i = 0; i < data.length; ++i) {
			result[i] = new char[data[i].length()];
			for (int j = 0; j < data[i].length(); ++j) {
				result[i][j] = data[i].charAt(j);
			}
		}
		return result;
	}

}
