package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearchTest {

	@Test
	public void test() {
		WordSearch w = new WordSearch();
		char[][] board = new char[][]{
				"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()
		};
		assertEquals(w.exist(board, "ABCCED"), true);
		assertEquals(w.exist(board, "SEE"), true);
		assertEquals(w.exist(board, "ABCB"), false);
	}
}
