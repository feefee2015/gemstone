public class SetZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] { { 0, 1 } };
		setZeroes(matrix);
		System.out.println(matrix);

	}

	static public void setZeroes(int[][] matrix) {
		boolean ii = false;
		boolean jj = false;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				ii = true;
				break;
			}
		}

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				jj = true;
				break;

			}
		}

		for (int i = 1; i < matrix.length; i++)
			for (int j = 1; j < matrix[0].length; j++) {

				if (matrix[i][j] == 0) {

					matrix[i][0] = 0;
					matrix[0][j] = 0;

				}
			}

		for (int i = 1; i < matrix.length; i++)
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;

				}
			}
		if (ii) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
		if (jj) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
	}

}
