/**
 * Given a binary tree
 * 
 * 
 * 
 * Node { Node* leftChild; Node* rightChild; Node* nextRight; } Populate the
 * nextRight pointers in each node.
 */

class Node {
	int i;
	Node left;
	Node right;
	Node nextRight;

	public Node(int i) {
		this.i = i;
	}
}

public class RightNext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void f(Node root) {
		if (root == null) {
			return;
		}

		if (root.left != null && root.right != null) {
			root.left.nextRight = root.right;
		}
		Node rightMost = root.right;
		if (rightMost == null) {
			rightMost = root.left;
		}
		if (rightMost != null) {
			if (root.nextRight != null) {
				if (root.nextRight.left != null) {
					rightMost.nextRight = root.nextRight.left;
				} else if (root.nextRight.right != null) {
					rightMost.nextRight = root.nextRight.right;
				}
			}

		}
		f(root.left);
		f(root.right);

	}

}
