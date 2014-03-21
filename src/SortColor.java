public class SortColor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[] { 1, 2, 3, 2, 1, 3, 2, 2, 3, 2, 1, 3 };
		sortColors(A);
		for (int i : A)
			System.out.print(i + " ");
	}

	static public void sortColors(int[] A) {
		int i = 0;
		int j = A.length - 1;

		int current = i;
		while (i <= j && current <= j) {

			if (i < A.length && A[i] < 2) {
				i++;
				continue;
			}
			if (j >= 0 && A[j] > 2) {
				j--;
				continue;
			}
			current = Math.max(current, i);
			if (A[current] < 2) {
				int temp = A[i];
				A[i] = A[current];
				A[current] = temp;
				i++;

			} else if (A[current] == 2) {
				current++;
			} else {
				int temp = A[j];
				A[j] = A[current];
				A[current] = temp;
				j--;
			}
		}
	}

}
