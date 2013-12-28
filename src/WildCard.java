import java.util.Date;

public class WildCard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date t = new Date();
		System.out.println(isMatch2("babba", "*?*?"));
		System.out.println(new Date().getTime() - t.getTime());

	}

	static boolean isMatch(String s, String p) {
		if (s.isEmpty()) {
			return p.isEmpty() || p.equals("*");
		}
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		if (s.charAt(0) == p.charAt(0)) {

			return isMatch(s.substring(1), p.substring(1));

		}
		if (p.charAt(0) != '*' && p.charAt(0) != '?') {
			return false;
		}

		if (s.charAt(s.length() - 1) == p.charAt(p.length() - 1)) {

			return isMatch(s.substring(0, s.length() - 1),
					p.substring(0, p.length() - 1));

		}
		if (p.charAt(p.length() - 1) != '*' && p.charAt(p.length() - 1) != '?') {
			return false;
		}

		if (p.charAt(0) == '?') {
			return isMatch(s.substring(1), p.substring(1));
		}

		int i = 0;
		while (i < p.length() && p.charAt(i) == '*') {
			i++;
		}
		if (i == p.length()) {
			return true;
		}

		return isMatch(s, p.substring(i))
				|| // treat * as empty
				isMatch(s.substring(1), p.substring(i))
				|| isMatch(s.substring(1), p.substring(i - 1));

	}

	static boolean isMatch2(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
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
		int len2 = p.length();
		boolean[][] match = new boolean[2][len2];
		for (int i = 1; i <= len1; i++)
			for (int j = 1; j <= len2; j++) {
				int x = (i - 1) % 2;
				int x_1 = (x + 1) % 2;
				if (i == 1 && j == 1) {
					if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '*'
							|| p.charAt(0) == '?') {
						match[x][j - 1] = true;
					} else {
						match[x][j - 1] = false;
					}
					continue;

				}
				if (j == 1) {
					match[x][j - 1] = (p.charAt(0) == '*');
					continue;
				}
				if (i == 1) {
					match[x][j - 1] = (p.length() == 2 && ((p.charAt(0) == '*' && (p
							.charAt(1) == s.charAt(0) || p.charAt(1) == '?')) || (p
							.charAt(1) == '*' && (p.charAt(0) == s.charAt(0) || p
							.charAt(0) == '?'))));
					continue;
				}

				String s1 = s.substring(0, i);
				String p1 = p.substring(0, j);
				if (s1.charAt(i - 1) == p1.charAt(j - 1)) {
					match[x][j - 1] = match[x_1][j - 2];
				} else {
					if (p1.charAt(j - 1) != '*' && p1.charAt(j - 1) != '?') {
						match[x][j - 1] = false;
					} else if (p1.charAt(j - 1) == '*') {
						match[x][j - 1] = match[x_1][j - 2]
								|| match[x_1][j - 1] || match[x][j - 2];
					} else {
						match[x][j - 1] = match[x_1][j - 2];
					}
				}
				continue;

			}
		return match[(len1 - 1) % 2][len2 - 1];
	}

}
