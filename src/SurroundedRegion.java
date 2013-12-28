import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegion {
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
		char[][] board = new char[4][4];
		board[0] = new char[] { 'X', 'X', 'X', 'X' };
		board[1] = new char[] { 'X', '0', '0', 'X' };
		board[2] = new char[] { 'X', 'X', '0', 'X' };
		board[3] = new char[] { 'X', '0', 'X', 'X' };

		SurroundedRegion sr = new SurroundedRegion();
		sr.solve(board);
		System.out.println(board[0]);
		System.out.println(board[1]);
		System.out.println(board[2]);
		System.out.println(board[3]);

	}

	public void solve(char[][] board) {
		int dimx = board.length;
		if (dimx <= 1) {
			return;
		}
		int dimy = board[0].length;
		if (dimy <= 1) {
			return;
		}
		Queue<Position> board0 = new LinkedList<Position>();
		for (int i = 0; i < dimx; i += dimx - 1)
			for (int j = 0; j < dimy; j++) {
				if (board[i][j] == '0') {
					board0.add(new Position(i, j));
				}
			}

		for (int i = 0; i < dimy; i += dimy - 1)
			for (int j = 0; j < dimx; j++) {
				if (board[j][i] == '0') {
					board0.add(new Position(j, i));
				}
			}

		while (!board0.isEmpty()) {
			Position candidate = board0.remove();
			if (board[candidate.x][candidate.y] != '0') {
				continue;
			}
			ArrayList<Position> neighbors = getNeighbor(candidate, board);
			board[candidate.x][candidate.y] = 'Y';
			board0.addAll(neighbors);
		}
		for (int i = 0; i < dimx; i++)
			for (int j = 0; j < dimy; j++) {
				if (board[i][j] == 'Y') {
					board[i][j] = '0';
				} else if (board[i][j] == '0') {
					board[i][j] = 'X';
				}
			}

	}

	static ArrayList<Position> getNeighbor(Position p, char[][] board) {
		ArrayList<Position> neighbors = new ArrayList<Position>();
		char c = board[p.x][p.y];
		int dimx = board.length;
		int dimy = board[0].length;

		int x = p.x - 1;
		int y = p.y;
		if (x >= 0 && x < dimx && y >= 0 && y < dimy
				&& board[x][y] == board[p.x][p.y]) {
			neighbors.add(new Position(x, y));

		}
		x = p.x + 1;
		y = p.y;
		if (x >= 0 && x < dimx && y >= 0 && y < dimy
				&& board[x][y] == board[p.x][p.y]) {
			neighbors.add(new Position(x, y));

		}
		x = p.x;
		y = p.y - 1;
		if (x >= 0 && x < dimx && y >= 0 && y < dimy
				&& board[x][y] == board[p.x][p.y]) {
			neighbors.add(new Position(x, y));

		}
		x = p.x;
		y = p.y + 1;
		if (x >= 0 && x < dimx && y >= 0 && y < dimy
				&& board[x][y] == board[p.x][p.y]) {
			neighbors.add(new Position(x, y));

		}

		return neighbors;
	}

}
