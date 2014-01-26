import java.util.ArrayList;
import java.util.Stack;

public class PreOrderIterative {
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

	}

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		result.add(root.val);
		TreeNode poped = null;
		while (!stack.empty()) {
			TreeNode node = stack.peek();
			if (poped != null) {
				if (poped == node.right || node.right == null
						&& poped == node.left) {
					poped = stack.pop();
				} else {
					stack.push(node.right);
					result.add(node.right.val);
					poped = null;
				}
				continue;
			}
			if (node.left != null) {
				stack.push(node.left);
				result.add(node.left.val);
			} else if (node.right != null) {
				stack.push(node.right);
				result.add(node.right.val);
			} else {
				poped = stack.pop();
			}

		}
		return result;

	}

}
