import java.util.ArrayList;

public class Parenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> result = generateParenthesis(3);
		for (String s : result) {
			System.out.print(s);
			System.out.print(" ");
		}

	}

	public static ArrayList<String> generateParenthesis0(int n, int m) {
		ArrayList<String> result = new ArrayList<String>();
		if (n == 0) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < m; j++) {
				sb.append(")");
			}
			result.add(sb.toString());
			return result;
		}
		ArrayList<String> result1 = generateParenthesis0(n - 1, m);
		for (String s : result1) {
			result.add("(" + s);
		}
		if (n < m) {
			ArrayList<String> result2 = generateParenthesis0(n, m - 1);
			for (String s : result2) {
				result.add(")" + s);
			}
		}
		return result;

	}

	public static ArrayList<String> generateParenthesis(int n) {
		return generateParenthesis0(n, n);
	}

}
