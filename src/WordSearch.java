import java.util.ArrayList;

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
		int a[][] = new int[3][4];
		System.out.print(a[0].length);
		System.out.println(exist(
				new char[][] { "ABCE".toCharArray(), "SFCS".toCharArray(),
						"ADEE".toCharArray() }, "ABCB"));

	}

	static public boolean exist(char[][] board, String word) {
		int x = board.length;
		int y = board[0].length;
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
		if (board[i][j] != word.charAt(0)) {
			return false;
		}

		visited[i][j] = true;
		ArrayList<Position> neighbors = getNeighbors(new Position(i, j),
				visited);
		for (Position n : neighbors) {
			if (found(board, visited, n.x, n.y, word.substring(1))) {
				return true;
			}
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

}
