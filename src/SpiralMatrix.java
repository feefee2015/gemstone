import java.util.ArrayList;

public class SpiralMatrix {

	/**
	 * Given a matrix of m x n elements (m rows, n columns), return all elements
	 * of the matrix in spiral order.
	 * 
	 * For example, Given the following matrix:
	 * 
	 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
	 * [1,2,3,6,9,8,7,4,5].
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] { { 2, 3 } };
		ArrayList<Integer> result = spiralOrder(matrix);
		System.out.println(result);
	}

	static public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int m = matrix.length;
		if (m == 0) {
			return result;
		}
		int n = matrix[0].length;

		int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int[] loops = new int[] { n - 1, m - 1, n - 1, m - 2 };

		int count = 0;
		int fullloop = 0;
		int x = 0;
		int y = 0;
		boolean needtoStop = false;
		boolean endingLine = false;
		result.add(matrix[0][0]);
		while (true) {
			int steps = loops[count];
			int[] move = dir[count];

			if (steps - fullloop * 2 <= 1 && count < 2) {
				needtoStop = true;
			}
			if (steps - fullloop * 2 == 0) {
				endingLine = true;
			}

			for (int i = 0; i < steps - fullloop * 2; i++) {
				x += move[1];
				y += move[0];
				result.add(matrix[y][x]);
			}

			if (++count == 4) {
				fullloop++;
				if (needtoStop) {
					break;
				}
				count = 0;
				x = x + 1;
				result.add(matrix[y][x]);
			}
			if (endingLine && count == 2) {
				break;
			}
		}
		return result;

	}
}
