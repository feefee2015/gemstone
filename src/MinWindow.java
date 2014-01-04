import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MinWindow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "caae";
		String T = "cae";
		System.out.println(minWindow(S, T));
	}

	/*
	 * Given a string S and a string T, find the minimum window in S which will
	 * contain all the characters in T in complexity O(n).
	 * 
	 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
	 * 
	 * Note: If there is no such window in S that covers all characters in T,
	 * return the emtpy string "".
	 * 
	 * If there are multiple such windows, you are guaranteed that there will
	 * always be only one unique minimum window in S.
	 */

	public static String minWindow(String S, String T) {

		HashMap<Character, Integer> counters = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (counters.containsKey(c)) {
				counters.put(c, counters.get(c) + 1);
			} else {
				counters.put(c, 1);
			}
		}
		HashMap<Character, Queue<Integer>> windows = new HashMap<Character, Queue<Integer>>();
		int queueSizeTotal = 0;
		int minPosition = -1;
		int result_start = -1;
		int result_len = Integer.MAX_VALUE;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (counters.containsKey(c)) {
				Queue<Integer> queue = windows.get(c);
				if (queue == null) {
					queue = new LinkedList<Integer>();
					windows.put(c, queue);
				}
				queue.add(i);
				if (minPosition == -1) {
					minPosition = i;
				}
				queueSizeTotal++;
				if (queue.size() > counters.get(c)) {
					int position = queue.remove();
					queueSizeTotal--;
					if (minPosition == position) {
						minPosition = Integer.MAX_VALUE; // now onto reset min
															// position
						for (Queue<Integer> positions : windows.values()) {
							while (!positions.isEmpty()
									&& positions.peek() < minPosition) {
								minPosition = positions.peek();
							}

						}
					}
				}

				if (queueSizeTotal == T.length()) {
					if (i - minPosition + 1 < result_len) {
						result_start = minPosition;
						result_len = i - minPosition + 1;
					}

				}
			}

		}
		if (result_start != -1) {
			return S.substring(result_start, result_start + result_len);
		}
		return "";

	}

}
