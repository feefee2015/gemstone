import java.util.ArrayList;

public class PalindromePartition {

	/**
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * 
	 * Return all possible palindrome partitioning of s.
	 * 
	 * For example, given s = "aab", Return
	 * 
	 * [ ["aa","b"], ["a","a","b"] ]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> resultSet = partition("aba");
		System.out.println(resultSet);
	}

	public static ArrayList<ArrayList<String>> partition(String s) {

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s == null || s.length() == 0) {
			return result;
		}
		boolean[][] palins = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++)
			for (int j = i; j < s.length(); j++) {
				palins[i][j] = isPalin(s, i, j);
			}
		ArrayList<ArrayList<String>>[] resultSet = new ArrayList[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (resultSet[i] == null) {
				resultSet[i] = new ArrayList<ArrayList<String>>();
			}
			if (i == 0) {
				ArrayList<String> item = new ArrayList<String>();
				item.add(s.substring(0, 1));

				resultSet[0].add(item);
			} else {
				for (int j = 0; j <= i; j++) {

					if (palins[j][i]) {
						ArrayList<ArrayList<String>> resultSet0;
						if (j == 0) {
							resultSet0 = add(null, s.substring(j, i + 1));
						} else {
							resultSet0 = add(resultSet[j - 1],
									s.substring(j, i + 1));
						}
						resultSet[i].addAll(resultSet0);
					}

				}
			}
		}
		return resultSet[resultSet.length - 1];
	}

	static boolean isPalin(String s, int i, int j) {

		while (i <= j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

	static ArrayList<ArrayList<String>> add(
			ArrayList<ArrayList<String>> resultSet, String s) {
		ArrayList<ArrayList<String>> finalResult = new ArrayList<ArrayList<String>>();
		if (resultSet == null || resultSet.size() == 0) {
			ArrayList<String> newItem = new ArrayList<String>();

			newItem.add(s);
			finalResult.add(newItem);
			return finalResult;
		}
		for (ArrayList<String> item : resultSet) {
			ArrayList<String> newItem = new ArrayList<String>();
			for (String ss : item) {
				newItem.add(ss);
			}
			newItem.add(s);
			finalResult.add(newItem);
		}
		return finalResult;

	}

}
