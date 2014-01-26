public class MaxPath {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * Given a binary tree, find the maximum path sum.
	 * 
	 * The path may start and end at any node in the tree.
	 * 
	 * For example: Given the below binary tree, 1 2/ \ 3 Return 6.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(-2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		System.out.println(maxPathSum(root));

	}

	public static int maxPathSum(TreeNode root) {
		Integer[] result = maxPathSum2(root);
		if (result[1] != null) {
			return Math.max(result[0], result[1]);
		}
		return result[0];
	}

	// result is an array of length 2. [0] is the max path with root as the
	// root. [1]
	// is the max path without root in the path
	static Integer[] maxPathSum2(TreeNode root) {
		if (root.left == null && root.right == null) {
			return new Integer[] { root.val, null };
		}

		if (root.left == null || root.right == null) {
			Integer[] val = null;
			if (root.left == null) {
				val = maxPathSum2(root.right);
			} else {
				val = maxPathSum2(root.left);
			}
			if (val[1] == null) {
				val[1] = val[0];
			} else {
				val[1] = Math.max(val[0], val[1]);
			}
			val[0] = val[0] > 0 ? root.val + val[0] : root.val;
			return val;
		}
		Integer[] left = maxPathSum2(root.left);
		Integer[] right = maxPathSum2(root.right);
		Integer[] result = new Integer[2];
		result[0] = root.val;
		int biggerBranch = Math.max(left[0], right[0]);
		if (biggerBranch > 0) {
			result[0] += biggerBranch;
		}
		int leftVal = (left[1] == null ? left[0] : Math.max(left[0], left[1]));
		int rightVal = (right[1] == null ? right[0] : Math.max(right[0],
				right[1]));
		int spanVal = root.val + left[0] + right[0];
		result[1] = Math.max(leftVal, rightVal);
		result[1] = Math.max(result[1], spanVal);

		return result;
	}

}
