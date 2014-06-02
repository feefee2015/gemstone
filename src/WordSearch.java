import java.util.ArrayList;
import java.util.HashSet;

public class WordSearch {

	static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = new String[] { "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaab" };
		System.out.println(input.length * input[0].length());
		int a[][] = new int[input.length][input[0].length()];
		char[][] matrix = new char[input.length][input[0].length()];
		int count = 0;
		for (String s : input) {
			matrix[count++] = s.toCharArray();
		}
		System.out.print(a[0].length);
		System.out
				.println(exist(
						matrix,
						"baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));

	}

	static public boolean exist(char[][] board, String word) {
		int x = board.length;
		int y = board[0].length;
		if (x * y < word.length()) {
			return false;
		}
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				if (found(board, visited, i, j, word)) {
					return true;
				}
			}
		return false;
	}

	private static boolean found(char[][] board, boolean[][] visited, int i,
			int j, String word) {
		if (word.length() == 0) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return false;
		}
		if (visited[i][j]) {
			return false;
		}

		if (board[i][j] != word.charAt(0)) {
			return false;
		}

		visited[i][j] = true;

		String w = word.substring(1);
		if (found(board, visited, i - 1, j, w)
				|| found(board, visited, i + 1, j, w)
				|| found(board, visited, i, j - 1, w)
				|| found(board, visited, i, j + 1, w)) {
			return true;
		}

		visited[i][j] = false;
		return false;

	}

	static ArrayList<Position> getNeighbors(Position p, boolean[][] visited) {
		int x = visited.length;
		int y = visited[0].length;
		ArrayList<Position> neighbors = new ArrayList<Position>();
		if (p.x - 1 >= 0 && !visited[p.x - 1][p.y]) {
			neighbors.add(new Position(p.x - 1, p.y));
		}
		if (p.x + 1 < x && !visited[p.x + 1][p.y]) {
			neighbors.add(new Position(p.x + 1, p.y));
		}
		if (p.y - 1 >= 0 && !visited[p.x][p.y - 1]) {
			neighbors.add(new Position(p.x, p.y - 1));
		}
		if (p.y + 1 < y && !visited[p.x][p.y + 1]) {
			neighbors.add(new Position(p.x, p.y + 1));
		}
		return neighbors;

	}

	static class pos {
		int i;
		int j;

		public pos(int _i, int _j) {
			i = _i;
			j = _j;
		}

		public int hashCode() {
			return 197 * i + 37 * j;
		}

		public boolean equals(Object p1) {
			pos p2 = (pos) p1;
			if (i == p2.i && j == p2.j)
				return true;
			return false;
		}
	}

	static boolean DFS(char[][] board, int i, int j, String word,
			HashSet<pos> set) {
		// break condition
		if (word == null || word.length() == 0)
			return true;
		// check if position<i,j> is out of boundary
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return false;
		// check if the character in current position<i,j> equals to the first
		// character in word
		if (board[i][j] != word.charAt(0))
			return false;
		// create a new set object with all previous visited nodes
		HashSet<pos> newSet = new HashSet<pos>(set);
		// check if <i,j> is visited or not
		if (newSet.add(new pos(i, j))) {
			// remove first character from word, recursively check four
			// adjacency directions
			String s = word.substring(1);
			return DFS(board, i + 1, j, s, newSet)
					|| DFS(board, i - 1, j, s, newSet)
					|| DFS(board, i, j - 1, s, newSet)
					|| DFS(board, i, j + 1, s, newSet);
		}
		return false;
	}

	static boolean exist3(char[][] board, String word) {
		if (board == null)
			return false;
		if (word == null)
			return true;
		// if word length bigger than board size, simply return false
		// if (word.length() > board.length * board[0].length)
		// return false;
		// traverse board, return true when find a valid path
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (DFS(board, i, j, word, new HashSet<pos>()))
					return true;
			}
		}
		return false;
	}

}
