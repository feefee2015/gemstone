class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}
}

public class AddNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = generate(new int[] { 7, 5, 9, 7, 8, 1, 8, 0, 9 });
		ListNode l2 = generate(new int[] { 7, 2, 4, 9, 8, 3, 9, 6, 5 });
		ListNode l3 = addTwoNumbers(l1, l2);
		while (l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}

	}

	static ListNode generate(int[] vals) {
		ListNode pre = null;
		ListNode head = null;
		for (int val : vals) {
			ListNode node = new ListNode(val);
			if (pre != null) {
				pre.next = node;
			} else {
				head = node;
			}
			pre = node;

		}
		return head;
	}

	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int carry = 0;
		ListNode head = null;
		ListNode pre = null;

		while (true) {

			if (l1 == null && l2 == null) {
				break;
			}
			int result = carry;
			if (l1 != null) {
				result += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				result += l2.val;
				l2 = l2.next;
			}
			if (result >= 10) {
				result = result - 10;
				carry = 1;
			} else {
				carry = 0;
			}
			ListNode node = new ListNode(result);
			if (pre != null) {
				pre.next = node;
			} else {
				head = node;
			}
			pre = node;

		}

		return head;

	}

}
