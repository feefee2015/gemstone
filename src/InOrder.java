import java.util.ArrayList;
import java.util.Stack;

public class InOrder {
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

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		boolean justPop = false;
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.left == null || justPop) {
				result.add(stack.pop().val);
				if (node.right != null) {
					stack.push(node.right);
					justPop = false;
				} else {
					justPop = true;
				}
			} else {
				stack.push(node.left);
				justPop = false;
			}
		}
		return result;
	}
}
