import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	class TreeNode {
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

	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (node == null) {
				if (!isSym(sb.toString())) {
					return false;
				}
				if (queue.isEmpty()) {
					return true;
				}
				queue.add(null);
				sb.setLength(0);
			} else {
				if (sb.length() != 0) {
					sb.append(",");
				}
				if (node.left == null) {
					sb.append("#");
				} else {
					sb.append(node.left.val);
					queue.add(node.left);
				}
				sb.append(",");
				if (node.right == null) {
					sb.append("#");
				} else {
					sb.append(node.right.val);
					queue.add(node.right);
				}

			}
		}
		return true;

	}

	static boolean isSym(String s) {
		String[] items = s.split(",");
		for (int i = 0, j = items.length - 1; i < j; i++, j--) {
			if (!items[i].equals(items[j])) {
				return false;
			}
		}
		return true;
	}
}
