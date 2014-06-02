public class ScrambleString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isScramble("eat", "tae"));

	}

	public static boolean isScramble2(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		int len = s1.length();
		if (len == 1) {
			return s1.equals(s2);
		}

		for (int i = 1; i < len; i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i), s2.substring(i))
					|| isScramble(s1.substring(0, i), s2.substring(len - i))
					&& isScramble(s1.substring(len - i), s2.substring(0, i))) {
				return true;
			}
		}
		return false;

	}

	public static boolean isScramble(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		int len = s1.length();
		if (len == 1) {
			return s1.equals(s2);
		}

		// used to index the scramble-match result, x,y,z represents
		// s1.substring(x,x+len) vs s2.substring(y, y+len)
		boolean[][][] result = new boolean[len][len][len];
		for (int z = 0; z < len; z++) {
			for (int x = 0; x < len && x + z + 1 <= len; x++) {
				for (int y = 0; y < len && y + z + 1 <= len; y++) {
					if (z == 0) {
						result[x][y][z] = (s1.charAt(x) == s2.charAt(y));
					} else {

						for (int i = 0; i < z; i++) {
							if (result[x][y][i]
									&& result[x + i + 1][y + i + 1][z - i - 1]
									|| result[x][y + z - i][i]
									&& result[x + i + 1][y][z - i - 1]) {
								result[x][y][z] = true;
								break;
							}

						}
					}
				}
			}
		}
		return result[0][0][len - 1];

	}

}
