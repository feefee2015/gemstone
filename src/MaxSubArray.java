public class MaxSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(max(new int[] { 13, -3, -25, 20, -3, -16, -23, 18,
				20, -7, 12, -5, -22, 15, -4, 7 }));

	}

	static int max(int[] a) {
		int[] result = new int[a.length];
		int max = a[0];
		result[0] = a[0];
		for (int i = 1; i < a.length; i++) {

			if (result[i - 1] <= 0) {
				result[i] = a[i];
			} else {
				result[i] = a[i] + result[i - 1];
			}
			max = Math.max(max, result[i]);

		}
		return max;
	}

}
