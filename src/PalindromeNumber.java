public class PalindromeNumber {

	/**
	 * Determine whether an integer is a palindrome. Do this without extra
	 * space.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(87));
		System.out.println(isPalindrome(1001));

	}

	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x < 10) {
			return true;
		}
		int i = 1;
		int y = x;
		int m = 1;
		while (y >= 10) {
			y /= 10;
			m *= 10;
			i++;

		}
		y = x;
		for (int j = 1; j <= i / 2; j++) {
			int a = y / m;
			int b = x % 10;
			if (a != b) {
				return false;
			}
			y %= m;
			m /= 10;

			x /= 10;
		}
		return true;

	}
}
