public class SumTreeNumber {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tr = new TreeNode(9);
		int result = sumNumbers(tr);
		System.out.println(result);

	}

	static int sumNumbers(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int sofar = root.val;
		return sumNumbers(root, sofar);

	}

	static int sumNumbers(TreeNode node, int sofar) {
		if (node.left == null && node.right == null) {

			return sofar;
		}
		int left = 0;
		int right = 0;
		if (node.left != null) {
			left = sumNumbers(node.left, sofar * 10 + node.left.val);
		}
		if (node.right != null) {
			right = sumNumbers(node.right, sofar * 10 + node.right.val);
		}
		return left + right;
	}

}
