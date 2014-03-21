import java.util.ArrayList;
import java.util.HashSet;

public class Subset2 {

	/**
	 * Given a collection of integers that might contain duplicates, S, return
	 * all possible subsets.
	 * 
	 * Note: Elements in a subset must be in non-descending order. The solution
	 * set must not contain duplicate subsets. For example, If S = [1,2,2], a
	 * solution is:
	 * 
	 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = subsetsWithDup(new int[] { 1, 2,
				2 });
		System.out.println(result);

	}

	static public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> al = subsetsWithDup(num, 0);
		al.add(new ArrayList<Integer>());
		return al;
	}

	static public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num,
			int start) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (num.length - start <= 0) {
			result.add(new ArrayList<Integer>());
			return result;
		}
		HashSet<Integer> used = new HashSet<Integer>();
		for (int i = start; i < num.length; i++) {
			if (start >= 1 && num[start - 1] > num[i]) {
				continue;
			}
			if (used.contains(num[i])) {
				continue;
			}
			used.add(num[i]);
			swap(num, start, i);

			ArrayList<Integer> item = getAL(num, 0, start + 1);
			result.add(item);
			if (start + 1 < num.length) {
				ArrayList<ArrayList<Integer>> result_1 = subsetsWithDup(num,
						start + 1);

				result.addAll(result_1);
			}

			swap(num, start, i);
		}

		return result;

	}

	static void swap(int[] num, int i, int j) {
		if (i != j && i < num.length && j < num.length) {
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
		}
	}

	static ArrayList<Integer> getAL(int[] num, int start, int end) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = start; i < end; i++) {
			al.add(num[i]);
		}
		return al;
	}

}
