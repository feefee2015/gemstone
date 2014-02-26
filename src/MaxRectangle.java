import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 * 
 * 
 */

public class MaxRectangle {

	static int[][] getHeight(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] height = new int[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {

				if (matrix[i][j] != '1') {
					height[i][j] = 0;
				} else {
					if (i == 0) {
						height[i][j] = 1;
					} else {
						height[i][j] = 1 + height[i - 1][j];
					}
				}
			}
		return height;
	}

	static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		int max = 0;
		Stack<Integer> s = new Stack<Integer>();

		int i = 0;
		while (i < height.length) {
			if (s.isEmpty()) {
				s.push(i++);
				continue;
			}
			int top = s.peek();
			if (height[top] <= height[i]) {
				s.push(i++);

			} else {
				int index = s.pop();
				int left = s.isEmpty() ? 0 : s.peek() + 1;
				int right = i - 1;
				int area = height[index] * (right - left + 1);
				max = Math.max(area, max);
			}
		}

		int top = s.peek();
		while (!s.isEmpty()) {
			int index = s.pop();
			int left;
			if (s.isEmpty()) {
				left = 0;
			} else {
				left = s.peek() + 1;
			}
			int right = top;

			int area = height[index] * (right - left + 1);
			max = Math.max(area, max);
		}
		return max;
	}

	public static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[][] height = getHeight(matrix);
		int m = height.length;
		int max = 0;
		for (int i = 0; i < m; i++) {
			max = Math.max(max, largestRectangleArea(height[i]));
		}
		return max;

	}

}
