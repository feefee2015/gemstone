/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = new int[] { 1, 5, 1 };
		nextPermutation(num);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}

	}

	static public void nextPermutation(int[] num) {
		boolean done = false;
		for (int i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				int j = i + 2;
				for (; j < num.length; j++) {
					if (num[j] <= num[i]) {
						break;
					}
				}

				j--;
				swap2(num, i, j);
				reverse(num, i + 1, num.length - 1);
				done = true;
				break;
			}
		}
		if (!done) {
			reverse(num, 0, num.length - 1);
		}

	}

	static void swap2(int num[], int i, int j) {
		num[i] = num[i] + num[j];
		num[j] = num[i] - num[j];
		num[i] = num[i] - num[j];
	}

	static void reverse(int num[], int start, int end) {
		if (start < end && end < num.length) {
			while (start < end) {

				swap2(num, start, end);
				start++;
				end--;
			}
		}
	}

}
