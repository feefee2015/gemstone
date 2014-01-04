import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SubStringCancatenation {
	public static void main(String[] args) {
		ArrayList<Integer> result = findSubstring("abababab", new String[] {
				"a", "b", "a" });
		System.out.println(result);

	}

	public static ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (S == null || L == null || L.length == 0) {
			return result;
		}
		int wordLen = L[0].length();
		Queue<String> queue = new LinkedList<String>();
		Map<String, Integer> counters = new HashMap<String, Integer>();
		Map<String, Integer> matcher = new HashMap<String, Integer>();
		for (String l : L) {
			if (matcher.containsKey(l)) {
				matcher.put(l, matcher.get(l) + 1);
			} else {
				matcher.put(l, 1);
			}
		}

		int totalValid = 0;
		for (int i = 0; i < wordLen; i++) {
			counters.clear();
			queue.clear();
			totalValid = 0;
			for (int j = i; j + wordLen <= S.length(); j += wordLen) {
				String sub = S.substring(j, j + wordLen);
				if (!matcher.containsKey(sub)) {
					counters.clear();
					queue.clear();
					totalValid = 0;
				} else {

					queue.add(sub);
					if (counters.containsKey(sub)) {
						counters.put(sub, counters.get(sub) + 1);
						if (counters.get(sub) <= matcher.get(sub)) {
							totalValid++;
						}
					} else {
						counters.put(sub, 1);
						totalValid++;
					}

					if (queue.size() > L.length) {
						String key = queue.remove();

						counters.put(key, counters.get(key) - 1);
						if (counters.get(key) < matcher.get(key)) {
							totalValid--;
						}

					}
					if (queue.size() == L.length && totalValid == L.length) {
						result.add(j - wordLen * (L.length - 1));
					}

				}
			}
		}
		return result;
	}

}
