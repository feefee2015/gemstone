import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutation2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = permute(new int[] { 1 });
		System.out.println(result);
	}

	static public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		permute(num, 0, result);
		return result;
	}

	static void permute(int[] num, int start,
			ArrayList<ArrayList<Integer>> result) {
		if (start == num.length - 1) {
			result.add(new ArrayList(Arrays.asList(num.clone())));
		} else {
			for (int i = start; i < num.length; i++) {
				swap(num, start, i);
				permute(num, start + 1, result);
				swap(num, start, i);
			}
		}
	}

	static void permute2(int[] num, int start,
			ArrayList<ArrayList<Integer>> result) {
		if (start == num.length - 1) {
			result.add(new ArrayList(Arrays.asList(num.clone())));
		} else {
			HashSet<Integer> prefix = new HashSet<Integer>();

			for (int i = start; i < num.length; i++) {
				if (prefix.contains(num[i])) {
					continue;
				}
				prefix.add(num[i]);
				swap(num, start, i);
				permute(num, start + 1, result);
				swap(num, start, i);
			}
		}
	}

	static void swap(int[] num, int i, int j) {
		if (i != j) {
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
		}
	}
}
