import java.util.ArrayList;
import java.util.Arrays;

public class Sum3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum3 sum3 = new Sum3();
		ArrayList<ArrayList<Integer>> result = sum3.threeSum(new int[] { -15,
				10, 0, -2, 14, -1, -10, -14, 10, 12, 6, -6, 10, 2, -11, -9, 2,
				13, 2, -9, -14, -12, -10, -12, 13, 13, -10, -3, 2, -11, 3, -6,
				6, 10, 7, 5, -13, 4, -2, 12, 1, -11, 14, -4, 6, -12, -6, -14,
				8, 11, -8, 1, 7, -3, 5, 5, -13, 10, 9, -3, 6, -10, 6, -3, 7,
				-9, -13, 9, 10, 0, -1, -11, 4, -10, -8, -13, -15, 2, -12, 8,
				-2, -12, -14, -10, -8, 6, 2, -5, -7, -11, 7, 14, -6, -10, -12,
				8, -4, -10, -5, 14, -3, 9, -12, 8, 14, -13 });
		for (ArrayList<Integer> item : result) {
			System.out.println(item);
		}

	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

		if (num.length < 3) {
			return null;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);

		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = num.length - 1;
			int target = 0 - num[i];
			while (j < k) {
				int current = num[j] + num[k];
				if (current == target) {
					while (j + 1 < k && num[j] == num[j + 1]) {
						j++;
					}

					while (k - 1 > j && num[k - 1] == num[k]) {
						k--;
					}
					result.add(new ArrayList<Integer>(Arrays.asList(num[i],
							num[j], num[k])));
					j = j + 1;

				} else if (current < target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return result;

	}

}
