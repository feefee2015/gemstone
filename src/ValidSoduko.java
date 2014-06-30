public class ValidSoduko {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValidSudoku(char[][] board) {
		if (board == null) {
			return false;
		}
		int m = board.length;
		int n = board[0].length;
		if (m != 9 || n != 9) {
			return false;
		}

		int[] a = new int[9];
		for (int j = 0; j < 9; j++) {
			reset(a);
			for (int i = 0; i < m; i++) {
				if (board[j][i] >= '1' && board[j][i] <= '9') {
					if (a[board[j][i] - '1'] != 0) {
						return false;
					}
					a[board[j][i] - '1'] = 1;
				}
			}
		}

		for (int j = 0; j < 9; j++) {
			reset(a);
			for (int i = 0; i < m; i++) {
				if (board[i][j] >= '1' && board[i][j] <= '9') {
					if (a[board[i][j] - '1'] != 0) {
						return false;
					}
					a[board[i][j] - '1'] = 1;
				}
			}
		}

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				reset(a);
				for (int k = 0; k < 3; k++)
					for (int l = 0; l < 3; l++) {
						int x = i * 3 + k;
						int y = j * 3 + l;
						if (board[x][y] >= '1' && board[x][y] <= '9') {
							if (a[board[x][y] - '1'] != 0) {
								return false;
							}
							a[board[x][y] - '1'] = 1;
						}
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
