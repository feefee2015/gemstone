
public class DistinctSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out
				.println(numDistinct(
						"adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
						"bcddceeeebecbc"));

	}

	public static int numDistinct(String S, String T) {
		if (S == null || T == null) {
			return 0;
		}
		if (T.isEmpty()) {
			return 1;
		}
		if (S.isEmpty()) {
			return 0;
		}
		if (S.length() < T.length()) {
			return 0;
		}
		// a 's 1st dimension index in s; 2nd dimension: length of string to
		// look at
		int[][] a = new int[S.length() + 1][T.length() + 1];
		for (int s = 0; s <= S.length(); s++)
			for (int t = 0; t <= T.length(); t++) {
				if (s < t) {
					a[s][t] = 0;
				} else {
					if (t == 0) {
						a[s][t] = 1;
					} else {
						a[s][t] = a[s - 1][t];
						if (S.charAt(s - 1) == T.charAt(t - 1)) {
							a[s][t] += a[s - 1][t - 1];
						}
					}

				}
			}
		return a[S.length()][T.length()];
	}

}
