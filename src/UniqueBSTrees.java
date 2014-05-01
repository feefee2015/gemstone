import java.util.ArrayList;

public class UniqueBSTrees {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public ArrayList<TreeNode> generateTrees(int n) {
		if (n < 1) {
			ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
			temp.add(null);
			return temp;
		}
		ArrayList<TreeNode>[] results = new ArrayList[n];
		for (int i = 1; i <= n; i++) {
			ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
			if (i == 1) {
				TreeNode node = new TreeNode(i);

				nodes.add(node);
				results[0] = nodes;
				continue;
			}
			for (int j = 1; j <= i; j++) {
				int left_num = j - 1;
				int right_num = i - j;

				ArrayList<TreeNode> left = new ArrayList<TreeNode>();
				ArrayList<TreeNode> right = new ArrayList<TreeNode>();
				if (left_num > 0) {
					for (TreeNode entry : results[left_num - 1]) {
						left.add(bump(0, entry));
					}
				}
				if (right_num > 0) {

					for (TreeNode entry : results[right_num - 1]) {
						right.add(bump(j, entry));
					}
				}
				ArrayList<TreeNode> result = new ArrayList<TreeNode>();
				if (left.size() == 0 && right.size() == 0) {
					TreeNode root = new TreeNode(j);
					nodes.add(root);
				} else if (left.size() == 0) {
					for (TreeNode entry : right) {
						TreeNode root = new TreeNode(j);
						root.right = entry;
						nodes.add(root);
					}
				} else if (right.size() == 0) {
					for (TreeNode entry : left) {
						TreeNode root = new TreeNode(j);
						root.left = entry;
						nodes.add(root);
					}
				} else {
					for (TreeNode left_entry : left)
						for (TreeNode right_entry : right) {
							TreeNode root = new TreeNode(j);
							root.left = left_entry;
							root.right = right_entry;
							nodes.add(root);
						}
				}

			}
			results[i - 1] = nodes;

		}
		return results[n - 1];

	}

	static TreeNode bump(int base, TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode root = new TreeNode(node.val + base);

		root.left = bump(base, node.left);
		root.right = bump(base, node.right);
		return root;
	}
}
