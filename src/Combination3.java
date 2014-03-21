import java.util.ArrayList;

/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7, 
 A solution set is: 
 [7] 
 [2, 2, 3] 
 */
public class Combination3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = combinationSum(new int[] { 9,
				10, 8, 4, 12, 5, 7 }, 17);
		System.out.println(result);

	}

	static public ArrayList<ArrayList<Integer>> combinationSum(
			int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (candidates == null || candidates.length == 0) {
			return result;
		}

		combinationSum(candidates, 0, target, new ArrayList<Integer>(), result);
		return result;
	}

	static void combinationSum(int[] num, int startIndex, int targetTotal,
			ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
		if (targetTotal == 0) {
			result.add((ArrayList<Integer>) current.clone());
		} else if (targetTotal > 0) {
			for (int i = 0; i < num.length; i++) {
				if (!current.isEmpty()
						&& current.get(current.size() - 1) > num[i]) {
					continue;
				}
				current.add(num[i]);

				combinationSum(num, i, targetTotal - num[i], current, result);

				current.remove(current.size() - 1);

			}
		}
	}

}
