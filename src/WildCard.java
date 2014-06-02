import java.util.Date;

public class WildCard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date t = new Date();
		System.out.println(isMatch2("cab", "*ab"));
		System.out.println(new Date().getTime() - t.getTime());

	}

	static boolean isMatch(String s, String p) {
		if (s.isEmpty()) {
			return p.isEmpty() || p.equals("*");
		}
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {

			return isMatch(s.substring(1), p.substring(1));

		}
		if (p.charAt(0) != '*') {
			return false;
		}

		int i = 0;
		while (i < p.length() && p.charAt(i) == '*') {
			i++;
		}
		if (i == p.length()) {
			return true;
		}

		return isMatch(s, p.substring(i))
				|| isMatch(s.substring(1), p.substring(i - 1));

	}

	static boolean isMatch2(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		int pLen = 0; // the min length of a string this pattern can represent
		if (!p.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			boolean preIsStar = false;

			for (int i = 0; i < p.length(); i++) {
				if (preIsStar && p.charAt(i) == '*') {
					continue;
				}

				if (p.charAt(i) == '*') {
					preIsStar = true;

				} else {
					pLen++;
					preIsStar = false;
				}
				sb.append(p.charAt(i));

			}
			p = sb.toString();
		}
		if (s.isEmpty()) {
			return p.isEmpty() || p.equals("*");
		}
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		if (p.equals("*")) {
			return true;
		}

		int len1 = s.length();
		if (len1 < pLen) {
			return false;
		}
		int len2 = p.length();
		boolean[][] match = new boolean[2][len2 + 1];
		for (int i = 0; i <= len1; i++)
			for (int j = 0; j <= len2; j++) {
				int x = i % 2;
				int x_1 = (x + 1) % 2;
				if (i == 0 && j == 0) {
					match[x][j] = true;
					continue;
				}

				if (j == 0) {
					match[x][j] = false;
					continue;
				}
				if (i == 0) {
					match[x][j] = match[x][j - 1] && p.charAt(j - 1) == '*';
					continue;
				}

				if (s.charAt(i - 1) == p.charAt(j - 1)
						|| p.charAt(j - 1) == '?') {
					match[x][j] = match[x_1][j - 1];
				} else {
					if (p.charAt(j - 1) != '*') {
						match[x][j] = false;
					} else {
						match[x][j] = match[x_1][j - 1] || match[x_1][j]
								|| match[x][j - 1];
					}
				}
				continue;

			}
		return match[len1 % 2][len2];
	}
	/*
	 * 
	 * static boolean isMatch3(String s, String p) { if (s == null || p == null)
	 * { return false; } int pLen = 0; // the min length of a string this
	 * pattern can represent if (!p.isEmpty()) { StringBuilder sb = new
	 * StringBuilder(); boolean preIsStar = false;
	 * 
	 * for (int i = 0; i < p.length(); i++) { if (preIsStar && p.charAt(i) ==
	 * '*') { continue; }
	 * 
	 * if (p.charAt(i) == '*') { preIsStar = true;
	 * 
	 * } else { pLen++; preIsStar = false; } sb.append(p.charAt(i));
	 * 
	 * } p = sb.toString(); } if (s.isEmpty()) { return p.isEmpty() ||
	 * p.equals("*"); } if (p.isEmpty()) { return s.isEmpty(); } if
	 * (p.equals("*")) { return true; }
	 * 
	 * int len1 = s.length(); if (len1 < pLen) { return false; } int len2 =
	 * p.length(); boolean[][] match = new boolean[len1][len2]; for (int i = 1;
	 * i <= len1; i++) for (int j = 1; j <= len2; j++) {
	 * 
	 * if (i == 1 && j == 1) { if (s.charAt(0) == p.charAt(0) || p.charAt(0) ==
	 * '*' || p.charAt(0) == '?') { match[i-1][j - 1] = true; } else {
	 * match[i-1][j - 1] = false; } continue;
	 * 
	 * } if (j == 1) { match[i-1][j - 1] = (p.charAt(0) == '*'); continue; } if
	 * (i == 1) { match[i-1][j - 1] = (p.length() == 2 && ((p.charAt(0) == '*'
	 * && (p .charAt(1) == s.charAt(0) || p.charAt(1) == '?')) || (p .charAt(1)
	 * == '*' && (p.charAt(0) == s.charAt(0) || p .charAt(0) == '?'))));
	 * continue; }
	 * 
	 * if (s.charAt(i - 1) == p.charAt(j - 1)) { match[x][j - 1] = match[x_1][j
	 * - 2]; } else { if (p.charAt(j - 1) != '*' && p.charAt(j - 1) != '?') {
	 * match[x][j - 1] = false; } else if (p.charAt(j - 1) == '*') { match[x][j
	 * - 1] = match[x_1][j - 2] || match[x_1][j - 1] || match[x][j - 2]; } else
	 * { match[x][j - 1] = match[x_1][j - 2]; } } continue;
	 * 
	 * } return match[(len1 - 1) % 2][len2 - 1]; }
	 */

}
