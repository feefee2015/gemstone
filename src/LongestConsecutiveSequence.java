import java.util.HashMap;

public class LongestConsecutiveSequence {

	/**
	 * Given an unsorted array of integers, find the length of the longest
	 * consecutive elements sequence.
	 * 
	 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive
	 * elements sequence is [1, 2, 3, 4]. Return its length: 4.
	 * 
	 * Your algorithm should run in O(n) complexity.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestConsecutive(new int[] { 0, -1 }));

	}

	static int longestConsecutive(int[] num) {
		// for each entry in the hashmap, the value part contains the
		// [lower_bound, upper_bound] that the key belongs to

		HashMap<Integer, Integer[]> temp = new HashMap<Integer, Integer[]>();
		int max = 0;
		for (int n : num) {
			if (temp.containsKey(n)) {
				continue;
			}
			Integer[] val = new Integer[2];
			if (temp.containsKey(n - 1)) {
				Integer lower = temp.get(n - 1)[0];
				val[0] = lower == null ? n - 1 : lower;

			} else {
				val[0] = n;
			}
			if (temp.containsKey(n + 1)) {
				Integer upper = temp.get(n + 1)[1];
				val[1] = upper == null ? n + 1 : upper;
			} else {
				val[1] = n;
			}
			temp.put(n, val);
			if (val[0] != n) {
				temp.put(val[0], val);
			}
			if (val[1] != n) {
				temp.put(val[1], val);
			}
			max = Math.max(max, val[1] - val[0] + 1);

		}
		return max;
	}
}
