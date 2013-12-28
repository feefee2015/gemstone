import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder1 {

	public static int findLadder2(String start, String end, HashSet<String> dict) {
		// dict.add(end);

		Queue<String> queue = new LinkedList<String>();

		queue.add(start);
		queue.add(null);
		HashSet<String> used = new HashSet<String>();
		used.add(start);
		HashSet<String> tempUsed = new HashSet<String>();

		int level = 0;
		while (!queue.isEmpty()) {

			String node = queue.remove();

			// at the end of one level
			if (node == null) {

				if (queue.isEmpty()) {
					break;
				}
				used.addAll(tempUsed);
				tempUsed.clear();
				queue.add(null);
				level++;
				continue;
			}

			boolean result = getNeighbors(node, dict, used, queue, tempUsed,
					end);
			if (result) {
				return level + 1 + 1;
			}

		}
		return 0;

	}

	static boolean getNeighbors(String current, HashSet<String> dict,
			HashSet<String> filter, Queue<String> queue,
			HashSet<String> tempUsed, String end) {

		String s = current;
		char[] chars = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {

			for (char c = 'a'; c <= 'z'; c++) {
				if (s.charAt(i) == c) {
					continue;
				}
				chars[i] = c;
				String neighbor = new String(chars);

				if (dict.contains(neighbor) && !filter.contains(neighbor)) {
					queue.add(neighbor);
					tempUsed.add(neighbor);
					if (neighbor.equals(end)) {

						return true;

					}

				}
			}
			chars[i] = s.charAt(i);

		}

		return false;

	}

	public int ladderLength(String start, String end, HashSet<String> dict) {
		return findLadder2(end, start, dict);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder1 ladder = new WordLadder1();
		HashSet<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		int l = ladder.ladderLength("a", "c", dict);
		System.out.println(l);

	}

}
