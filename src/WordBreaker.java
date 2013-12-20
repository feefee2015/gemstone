import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreaker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] seed = new String[] { "cat", "cats", "and", "sand", "dog" };
		Set<String> dict = new HashSet<String>();
		for (String entry : seed) {
			dict.add(entry);
		}

		// System.out.println(wordBreak2("ab", dict));

		ArrayList<String> result = wordBreak4("cat", dict);
		for (String entry : result) {
			System.out.println(entry);
		}

	}

	public static boolean wordBreak(String s, Set<String> dict) {

		if (s == null || s.isEmpty() || dict == null) {
			return false;
		}
		if (dict.contains(s)) {
			return true;
		}
		boolean[][] a = new boolean[s.length()][s.length()];

		for (int i = 1; i <= s.length(); i++) {
			String s1 = s.substring(0, i);
			if (dict.contains(s1)) {
				if (s.length() == i) {
					return true;
				}
				String s2 = s.substring(i, s.length());
				if (wordBreak(s2, dict)) {
					return true;
				}
			}
		}
		return false;

	}

	public static boolean wordBreak2(String s, Set<String> dict) {

		if (s == null || s.isEmpty() || dict == null) {
			return false;
		}
		if (dict.contains(s)) {
			return true;
		}
		boolean[][] a = new boolean[s.length()][s.length() + 1];

		for (int len = 1; len <= s.length(); len++)
			for (int start = 0; start <= s.length() - len; start++) {
				String s1 = s.substring(start, len + start);

				if (dict.contains(s1)) {
					a[start][start + len] = true;
					continue;
				}
				if (len == 1) {
					a[start][start + len] = false;
					continue;
				}
				for (int l = 1; l < s1.length(); l++) {
					a[start][start + len] = a[start][l + start]
							&& a[l + start][len + start];
					if (a[start][start + len]) {
						break;
					}
				}

			}
		return a[0][s.length()];

	}

	public static ArrayList<String> wordBreak3(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		if (s == null || s.isEmpty() || dict == null) {
			return null;
		}

		for (int i = 1; i <= s.length(); i++) {
			String s1 = s.substring(0, i);
			if (dict.contains(s1)) {

				if (s.length() == i) {
					result.add(s1);
					continue;
				}
				String s2 = s.substring(i, s.length());
				ArrayList<String> result0 = wordBreak3(s2, dict);
				if (result0 != null) {
					for (String entry : result0) {
						result.add(s1 + " " + entry);
					}

				}
			}
		}
		if (result.size() == 0) {
			return null;
		}
		return result;
	}

	public static ArrayList<String> wordBreak4(String s, Set<String> dict) {

		if (!wordBreak2(s, dict)) {
			return new ArrayList<String>();
		}

		ArrayList<String>[][] a = new ArrayList[s.length()][s.length() + 1];

		for (int len = 1; len <= s.length(); len++)
			for (int start = 0; start <= s.length() - len; start++) {
				HashSet<String> resultSet = new HashSet<String>();
				String s1 = s.substring(start, len + start);

				if (dict.contains(s1)) {
					// a[start][start + len].add(s1);
					resultSet.add(s1);
				}
				for (int l = 1; l < s1.length(); l++) {
					merge(resultSet, a[start][l + start], a[l + start][len
							+ start]);

				}
				a[start][start + len] = new ArrayList<String>();
				a[start][start + len].addAll(resultSet);

				// Collections.addAll(finalresult, resultSet);

			}
		return a[0][s.length()];

	}

	static void merge(HashSet<String> resultSet, ArrayList<String> s1,
			ArrayList<String> s2) {
		if (s1 == null || s1.size() == 0 || s2 == null || s2.size() == 0) {
			return;
		}

		for (String entry1 : s1)
			for (String entry2 : s2) {
				StringBuilder entry = new StringBuilder();
				entry.append(entry1);
				entry.append(" ");
				entry.append(entry2);
				resultSet.add(entry.toString());
			}

	}
}
