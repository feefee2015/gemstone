import java.util.Stack;

public class LargestRectangleArea {

	/**
	 * @param args
	 *            Given n non-negative integers representing the histogram's bar
	 *            height where the width of each bar is 1, find the area of
	 *            largest rectangle in the histogram.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = largestRectangleArea(new int[] { 1, 1 });

	}

	// key is to reduce the peak position
	public static int largestRectangleArea(int[] height) {
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

		// from left to right
		if (!s.isEmpty()) {
			int size = s.size();
			int tail = s.get(size - 1);
			for (int k = 0; k < size; k++) {
				int currentIndex = s.get(k);
				max = Math.max(max, height[currentIndex]
						* (tail - currentIndex + 1));
			}
		}

		// then from right to left
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
}
