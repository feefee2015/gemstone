public class ZigZagConvert {

	/**
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given
	 * number of rows like this: (you may want to display this pattern in a
	 * fixed font for better legibility)
	 * 
	 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
	 * Write the code that will take a string and make this conversion given a
	 * number of rows:
	 */
	public static void main(String[] args) {
		// should return "PAHNAPLSIIGYIR".
		// System.out.print(f("PAYPALISHIRING", 3));
		System.out.print(f("wgeislnowkhjaxt", 4));

	}

	static String f(String s, int row) {
		if (s == null) {
			throw new IllegalArgumentException();
		}
		if (row == 1) {
			return s;
		}
		int len = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < row && i < len; i++) {
			int pre = i;
			sb.append(s.charAt(pre));
			int j = 2 * row - 2;
			while (j - pre < len) {
				if (pre != j - pre) {
					sb.append(s.charAt(j - pre));
				}
				pre = j - pre;
				j += 2 * row - 2;
			}
		}
		return sb.toString();
	}

}
