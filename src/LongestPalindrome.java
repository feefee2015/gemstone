public class LongestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindrome lp = new LongestPalindrome();
		System.out.println(lp.longestPalindrome("abb"));
		System.out.println(1052254545 * 10);

	}

	public String longestPalindrome(String s) {
		char[] a = new char[2 * s.length() - 1];
		for (int i = 0; i < s.length(); i++) {
			a[2 * i] = s.charAt(i);
		}
		int midIndex = -1;
		int max = -1;
		for (int i = 0; i < a.length; i++) {
			int len = 0;
			for (; i - len >= 0 && i + len < a.length; len++) {
				if (a[i - len] != a[i + len]) {
					break;
				}
			}
			len--;
			if (a[i - len] == 0) {
				len--;
			}
			// it will not equal only on the original chars
			if (len > max) {
				midIndex = i;
				max = len;
			}
		}
		int start = (midIndex - max) / 2;
		int end = (midIndex + max) / 2;
		return s.substring(start, end + 1);
	}

}
