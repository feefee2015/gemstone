import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is: [ [2,4], [3,4], [2,3], [1,2],
 * [1,3], [1,4], ]
 * 
 * 
 */
public class Combination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = combine(2, 1);
	}

	static public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		combine(n, k, 0, path, result);
		return result;
	}

	static void combine(int n, int k, int min, ArrayList<Integer> path,
			ArrayList<ArrayList<Integer>> result) {
		for (int i = min + 1; i <= n; i++) {

			path.add(i);
			if (path.size() == k) {

				result.add((ArrayList<Integer>) path.clone());

			} else {
				combine(n, k, i, path, result);
			}
			path.remove(path.size() - 1);
		}
	}

}
