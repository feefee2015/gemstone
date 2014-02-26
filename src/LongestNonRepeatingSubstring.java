import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubstring {

	/**
	 * Given a string, find the length of the longest substring without
	 * repeating characters. For example, the longest substring without
	 * repeating letters for "abcabcbb" is "abc", which the length is 3. For
	 * "bbbbb" the longest substring is "b", with the length of 1.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out
				.println(lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}
		int start = 0;
		int max = 0;
		Map<Character, Integer> sub = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (sub.containsKey(c) && sub.get(c) >= start) {

				max = Math.max(max, i - start);
				start = sub.get(c) + 1;

			}
			sub.put(c, i);
		}
		max = Math.max(max, s.length() - start);
		return max;

	}

}
