import java.util.ArrayList;
import java.util.HashSet;

/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 A solution set is: 
 [1, 7] 
 [1, 2, 5] 
 [2, 6] 
 [1, 1, 6] 
 */
public class Combination2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = combinationSum2(
				new int[] { 1, 2 }, 1);
		System.out.println(result);
	}

	static public ArrayList<ArrayList<Integer>> combinationSum2(int[] num,
			int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		combinationSum2(num, 0, target, result);
		return result;
	}

	static void combinationSum2(int[] num, int startIndex, int targetTotal,
			ArrayList<ArrayList<Integer>> result) {
		if (targetTotal == 0) {
			result.add(convert(num, startIndex - 1));
		} else if (targetTotal > 0) {
			HashSet<Integer> prefix = new HashSet<Integer>();

			for (int i = startIndex; i < num.length; i++) {
				if (prefix.contains(num[i])) {
					continue;
				}
				if (startIndex > 0 && num[startIndex - 1] > num[i]) {
					continue;
				}
				prefix.add(num[i]);
				swap(num, startIndex, i);
				combinationSum2(num, startIndex + 1, targetTotal
						- num[startIndex], result);
				swap(num, startIndex, i);
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

	static ArrayList<Integer> convert(int[] num, int end) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i <= end; i++) {
			result.add(num[i]);
		}
		return result;
	}

}
