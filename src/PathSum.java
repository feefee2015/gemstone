import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class PathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> finalResult = new ArrayList<ArrayList<Integer>>();
		if (root.left == null && root.right == null && root.val == sum) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			result.add(root.val);

			finalResult.add(result);
			return finalResult;
		}

		ArrayList<ArrayList<Integer>> left = pathSum(root.left, sum - root.val);
		ArrayList<ArrayList<Integer>> right = pathSum(root.right, sum
				- root.val);
		if (left != null) {

			finalResult.addAll(left);
		}
		if (right != null) {
			finalResult.addAll(right);
		}
		ArrayList<ArrayList<Integer>> finalResult2 = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> item : finalResult) {
			item.add(0, root.val);
			finalResult2.add(item);
		}
		if (!finalResult2.isEmpty()) {
			return finalResult2;
		}
		return null;

	}
}
