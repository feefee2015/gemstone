import java.util.Stack;

public class EvalReversePolish {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<String>();
		for (String token : tokens) {
			if (!isOperator(token)) {
				stack.push(token);
			} else {
				int right = Integer.parseInt(stack.pop());
				int left = Integer.parseInt(stack.pop());
				int result;
				if (token.equals("+")) {
					result = left + right;
				} else if (token.equals("-")) {
					result = left - right;
				} else if (token.equals("*")) {
					result = left * right;
				} else {
					result = left / right;
				}
				stack.push(result + "");

			}
		}
		return Integer.parseInt(stack.pop());
	}

	static boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}

}
