public class SudokuSolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public void solveSudoku(char[][] board) {

		if (board == null) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		if (m != 9 || n != 9) {
			return;
		}
		boolean[][] given = new boolean[9][9];
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (board[i][j] >= '1' && board[i][j] <= '9') {
					given[i][j] = true;
				} else {
					given[i][j] = false;
				}
			}
		solveSudoku(board, given, 0);
	}

	static public boolean solveSudoku(char[][] board, boolean[][] given,
			int index) {
		if (index == 81) {
			return true;
		}
		int i = index / 9;
		int j = index % 9;

		if (given[i][j]) {
			return solveSudoku(board, given, index + 1);
		}
		for (char c = '1'; c <= '9'; c++) {
			board[i][j] = c;
			if (isValidSudoku(board, i, j)) {
				boolean result = solveSudoku(board, given, index + 1);
				if (result) {
					return true;
				}
			}
		}
		board[i][j] = '.';
		return false;

	}

	static public boolean isValidSudoku(char[][] board, int x, int y) {

		int[] a = new int[9];
		reset(a);
		for (int j = 0; j < 9; j++) {

			if (board[x][j] >= '1' && board[x][j] <= '9') {
				if (a[board[x][j] - '1'] != 0) {
					return false;
				}
				a[board[x][j] - '1'] = 1;
			}

		}
		reset(a);
		for (int j = 0; j < 9; j++) {

			if (board[j][y] >= '1' && board[j][y] <= '9') {
				if (a[board[j][y] - '1'] != 0) {
					return false;
				}
				a[board[j][y] - '1'] = 1;
			}

		}

		reset(a);
		for (int k = 0; k < 3; k++)
			for (int l = 0; l < 3; l++) {
				int p = x / 3 * 3 + k;
				int q = y / 3 * 3 + l;
				if (board[p][q] >= '1' && board[p][q] <= '9') {
					if (a[board[p][q] - '1'] != 0) {
						return false;
					}
					a[board[p][q] - '1'] = 1;
				}
			}

		return true;

	}

	static void reset(int a[]) {
		for (int i = 0; i < a.length; i++) {
			a[i] = 0;
		}
	}

}
