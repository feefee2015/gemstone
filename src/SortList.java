import java.util.ArrayList;

class ListNode0 {
	int val;
	ListNode0 next;

	ListNode0(int x) {
		val = x;
		next = null;
	}

	static ListNode0 getList(int[] vals) {
		ListNode0 pre = null;
		ListNode0 result = null;
		for (int i = 0; i < vals.length; i++) {
			ListNode0 node = new ListNode0(vals[i]);
			if (i == 0) {
				result = node;
			}
			if (pre != null) {
				pre.next = node;
			}
			pre = node;
		}
		return result;

	}

	void print() {
		ListNode0 p = this;
		while (p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
}

public class SortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode0 result = sortList(ListNode0
				.getList(new int[] { 2, 1, 9, 7, 5 }));
		result.print();

	}

	public static ListNode0 sortList(ListNode0 head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (head == null) {
			return null;
		}
		ArrayList<ListNode0> heads = new ArrayList<ListNode0>();
		ArrayList<ListNode0> heads_2 = new ArrayList<ListNode0>();
		while (head != null) {
			ListNode0 next = head.next;
			head.next = null;
			heads.add(head);
			head = next;
		}
		while (heads.size() > 1) {
			heads_2.clear();
			int i = 0;
			for (; i + 1 < heads.size(); i += 2) {
				heads_2.add(merge(heads.get(i), heads.get(i + 1)));
			}
			if (i < heads.size()) {
				heads_2.add(heads.get(i));
			}
			ArrayList<ListNode0> temp = heads;
			heads = heads_2;
			heads_2 = temp;
		}
		if (heads.isEmpty()) {
			return null;
		}
		return heads.get(0);

	}

	static ListNode0 merge(ListNode0 l1, ListNode0 l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode0 p1 = l1;
		ListNode0 p2 = l2;
		ListNode0 result = null;
		ListNode0 chain = null;
		while (p1 != null && p2 != null) {
			ListNode0 candidate = p1.val < p2.val ? p1 : p2;

			if (chain == null) {
				chain = candidate;
				result = chain;
			} else {
				chain.next = candidate;
				chain = candidate;
			}
			if (candidate == p1) {
				p1 = p1.next;
			} else {
				p2 = p2.next;
			}
		}
		while (p1 != null) {
			chain.next = p1;
			chain = chain.next;
			p1 = p1.next;
		}
		while (p2 != null) {
			chain.next = p2;
			chain = chain.next;
			p2 = p2.next;
		}
		return result;
	}
}
