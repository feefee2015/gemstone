/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * 
 * 
 */
public class Cycle2 {

	class ListNode {
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

	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		int count = 0;
		int size = -1;
		while (true) {
			if (size >= 0) {
				size++;
			}
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == null || p2 == null) {
				return null;
			}
			if (p1 == p2) {
				count++;
				if (count == 2) {
					break;
				} else {
					// start to count
					size = 0;
				}
			}
		}
		p1 = head;
		p2 = head;
		while (size-- > 0) {
			p2 = p2.next;
		}
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

}
