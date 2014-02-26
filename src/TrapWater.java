import java.util.Stack;

public class TrapWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trap(new int[] { 2, 0, 2 }));
	}

	/**
	 * Given n non-negative integers representing an elevation map where the
	 * width of each bar is 1, compute how much water it is able to trap after
	 * raining.
	 * 
	 * @param A
	 * @return
	 */

	public static int trap(int[] A) {
		int total = 0;
		if (A == null || A.length == 0) {
			return total;
		}
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
				continue;
			}
			int top = stack.peek();
			if (A[top] > A[i]) {
				stack.push(i);
			} else if (A[top] == A[i]) {
				stack.pop();
				stack.push(i);
			} else {

				while (A[top] < A[i]) {

					stack.pop();
					if (stack.isEmpty()) {

						break;
					} else {
						int popedHeight = A[top];
						top = stack.peek();
						int height = Math.min(A[top], A[i]) - popedHeight;
						int width = i - 1 - (top + 1) + 1;
						total += height * width;

					}
				}
				stack.push(i);
			}
		}
		return total;

	}
}
