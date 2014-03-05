/*
 * Two elements of a binary search tree (BST) are swapped by mistake.

 	Recover the tree without changing its structure.
 */
public class RecoverBST {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class TreeNodeGroup {
		TreeNode pre;
		TreeNode current;
		TreeNode err;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void recoverTree(TreeNode root) {
		TreeNodeGroup ng = new TreeNodeGroup();

		boolean done = traverse(root, ng);
		if (!done) {
			int temp = ng.err.val;
			ng.err.val = ng.current.val;
			ng.current.val = temp;
		}

	}

	public boolean traverse(TreeNode node, TreeNodeGroup ng) {
		if (node == null) {
			return false;
		}
		boolean done = traverse(node.left, ng);
		if (done) {
			return done;
		}
		ng.pre = ng.current;
		ng.current = node;

		if (ng.pre != null && ng.pre.val > ng.current.val) {
			if (ng.err == null) {
				ng.err = ng.pre;

			}
		}
		if (ng.err != null) {

			if (node.val > ng.err.val) {
				int temp = ng.err.val;
				ng.err.val = ng.pre.val;
				ng.pre.val = temp;
				return true;
			}
		}
		return traverse(node.right, ng);

	}
}
