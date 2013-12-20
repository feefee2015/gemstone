import java.util.Date;

public class DistinctSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date e = new Date();
		System.out.println(e);
		System.out
				.println(numDistinct2(
						"adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
						"bcddceeeebecbc"));
		Date d = new Date();
		System.out.println(d);
		// System.out
		// .println(numDistinct(
		// "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
		// "bcddceeeebecbc"));

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
		if (S.charAt(0) == T.charAt(0)) {
			return numDistinct(S.substring(1), T.substring(1))
					+ numDistinct(S.substring(1), T);
		}
		return numDistinct(S.substring(1), T);
	}

	public static int numDistinct0(String S, String T) {
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
		int[][][][] a = new int[S.length() + 1][S.length()][T.length() + 1][T
				.length()];
		for (int tlen = 1; tlen <= T.length(); tlen++)
			for (int slen = tlen; slen <= S.length(); slen++)
				for (int s0 = 0; s0 <= S.length() - slen; s0++)
					for (int t0 = 0; t0 <= T.length() - tlen; t0++) {
						String s = S.substring(s0, s0 + slen);
						String t = T.substring(t0, t0 + tlen);

						if (s.charAt(0) == t.charAt(0)) {
							if (slen == 1) {
								a[slen][s0][tlen][t0] = 1;
							} else {
								if (tlen == 1) {
									a[slen][s0][tlen][t0] = 1 + a[slen - 1][s0 + 1][tlen][t0];
								} else {
									a[slen][s0][tlen][t0] = a[slen - 1][s0 + 1][tlen - 1][t0 + 1]
											+ a[slen - 1][s0 + 1][tlen][t0];
								}
							}
						} else {
							if (slen == 1) {
								a[slen][s0][tlen][t0] = 0;
							} else {
								a[slen][s0][tlen][t0] = a[slen - 1][s0 + 1][tlen][t0];
							}
						}
					}

		return a[S.length()][0][T.length()][0];
	}

	public static int numDistinct2(String S, String T) {
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
		int[][][][] a = new int[S.length() + 1][S.length()][T.length() + 1][T
				.length()];
		for (int tlen = 1; tlen <= T.length(); tlen++)
			for (int slen = tlen; slen <= S.length(); slen++)
				for (int s0 = 0; s0 <= S.length() - slen; s0++)
					for (int t0 = 0; t0 <= T.length() - tlen; t0++) {

						String s = S.substring(s0, s0 + slen);
						String t = T.substring(t0, t0 + tlen);
						if (slen == tlen) {
							if (s.equals(t)) {
								a[slen][s0][tlen][t0] = 1;
							} else {
								a[slen][s0][tlen][t0] = 0;
							}
							continue;
						}
						if (s.charAt(0) == t.charAt(0)) {

							if (tlen == 1) {
								a[slen][s0][tlen][t0] = 1 + a[slen - 1][s0 + 1][tlen][t0];
							} else {
								a[slen][s0][tlen][t0] = a[slen - 1][s0 + 1][tlen - 1][t0 + 1]
										+ a[slen - 1][s0 + 1][tlen][t0];
							}

						} else {

							a[slen][s0][tlen][t0] = a[slen - 1][s0 + 1][tlen][t0];

						}
					}

		return a[S.length()][0][T.length()][0];
	}

}
