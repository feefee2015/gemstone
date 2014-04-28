public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11", "1"));

	}

	static String addBinary(String a, String b) {
		int i = a.length();
		int j = b.length();
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while (i > 0 && j > 0) {
			int c1 = (a.charAt(--i) == '1' ? 1 : 0);
			int c2 = (b.charAt(--j) == '1' ? 1 : 0);
			int temp = c1 + c2 + carry;
			sb.append(temp % 2);
			carry = temp / 2;
		}
		while (i > 0) {
			int c1 = a.charAt(--i) == '1' ? 1 : 0;

			int temp = c1 + carry;
			sb.append(temp % 2);
			carry = temp / 2;
		}
		while (j > 0) {

			int c2 = b.charAt(--j) == '1' ? 1 : 0;
			int temp = c2 + carry;
			sb.append(temp % 2);
			carry = temp / 2;
		}
		if (carry == 1) {
			sb.append(carry);
		}
		return sb.reverse().toString();

	}

}
