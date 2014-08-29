package leetcode_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch {
	class Coordinate {
		int x;
		int y;
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public boolean isOnBoard(char[][] board) {
			if (x < 0 || x >= board.length) return false;
			if (y < 0 || y >= board[0].length) return false;
			return true;
		}
	}
    public boolean exist(char[][] board, String word) {
    	List<Coordinate> firstCharCoords = find1stCharCoordinates(board, word);
    	if (firstCharCoords == null) return false;
    	for (Coordinate coord : firstCharCoords) {
    		boolean[][] visited = new boolean[board.length][board[0].length];
			if (search(board, coord, word, 0, visited)) return true;
    	}
        return false;
    }
	private List<Coordinate> find1stCharCoordinates(char[][] board, String word) {
		Map<Character, List<Coordinate>> map = new HashMap<>();
    	for (int i = 0; i < board.length; ++i) {
    		for (int j = 0; j < board[i].length; ++j) {
    			char c = board[i][j];
    			List<Coordinate> cords = map.get(c);
    			if (cords == null) {
    				cords = new ArrayList<>();
    				cords.add(new Coordinate(i, j));
    				map.put(c, cords);
    			} else {
    				cords.add(new Coordinate(i, j));
    			}
    		}
    	}
    	List<Coordinate> firstChar = map.get(word.charAt(0));
		return firstChar;
	}
	private boolean search(char[][] board, Coordinate coord, String word, int index, boolean[][] visited) {
		if (coord.isOnBoard(board) == false) return false;
		if (visited[coord.x][coord.y] == true) return false;
		if (board[coord.x][coord.y] != word.charAt(index)) return false;
		if (board[coord.x][coord.y] == word.charAt(index) && index == word.length() - 1) return true;
		visited[coord.x][coord.y] = true;
		boolean find = search(board, new Coordinate(coord.x + 1, coord.y), word, index + 1, visited) ||
				search(board, new Coordinate(coord.x, coord.y + 1), word, index + 1, visited) ||
				search(board, new Coordinate(coord.x - 1, coord.y), word, index + 1, visited) ||
				search(board, new Coordinate(coord.x, coord.y - 1), word, index + 1, visited);
		if (find) return true;
		visited[coord.x][coord.y] = false;
		return false;
	}
}
