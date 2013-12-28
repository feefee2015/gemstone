public class IsNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumber("-1."));

	}

	public static boolean isNumber(String s) {
		if (s == null || (s = s.trim()).isEmpty()) {
			return false;
		}
		if (s.charAt(0) == '-') {
			s = s.substring(1).trim();
			if (s.isEmpty()) {
				return false;
			}

		}
		boolean hasDot = false;
		boolean hasE = false;
		boolean hasNumber = false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				hasNumber = true;
				continue;
			}
			if (c == '.') {
				if (hasDot) {
					return false;
				}
				hasDot = true;
				continue;
			}
			if (c == 'e') {
				if (hasE == true || !hasNumber) {
					return false;
				}
				hasE = true;
				hasDot = false;
				hasNumber = false;
				continue;
			}
			if (c == '-') {
				if (hasE && s.charAt(i - 1) == 'e') {
					continue;
				}
			}
			return false;

		}
		return hasNumber;

	}

}
