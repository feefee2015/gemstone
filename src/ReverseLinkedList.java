

public class ReverseLinkedList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(5);
		n1.next = n2;
		ListNode result = rll.reverseBetween(n1, 1, 2);
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}
		ListNode head1 = head;
		ListNode tail1 = null;
		for (int i = 1; i < m; i++) {
			if (i == m - 1) {
				tail1 = head;
			}
			head = head.next;
		}
		ListNode tail2 = head;

		ListNode pre = null;
		ListNode current = head;

		for (int i = m; i <= n; i++) {
			ListNode next = current.next;

			current.next = pre;
			pre = current;
			current = next;
		}
		if (pre == null) { // no reversing sublist at all
			return head1;
		}
		ListNode head2 = pre;
		ListNode head3 = current;
		tail2.next = head3;
		if (tail1 != null) {
			tail1.next = head2;
			return head1;
		}
		return head2;
	}

}
