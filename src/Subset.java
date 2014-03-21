import java.util.ArrayList;
import java.util.Arrays;

public class Subset {
	/*
	 * Given a set of distinct integers, S, return all possible subsets.
	 * 
	 * Note: Elements in a subset must be in non-descending order. The solution
	 * set must not contain duplicate subsets. For example, If S = [1,2,3], a
	 * solution is:
	 * 
	 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = subsets(new int[] { 1, 2, 3 });
		System.out.println(result);
	}

	static public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		return subsets(S, 0, S.length);
	}

	static public ArrayList<ArrayList<Integer>> subsets(int[] S, int start,
			int end) {
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (S == null || end - start == 0) {
			ArrayList<Integer> item = new ArrayList<Integer>();
			result.add(item);
			return result;

		}
		ArrayList<ArrayList<Integer>> result_1 = subsets(S, start, end - 1);
		result.addAll(result_1);
		for (ArrayList<Integer> entry : result_1) {
			ArrayList<Integer> c = (ArrayList<Integer>) entry.clone();
			c.add(S[end - 1]);
			result.add(c);
		}
		return result;
	}

}
