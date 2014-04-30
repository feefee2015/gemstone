public class SearchRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(search(new int[] { 3, 5, 1 }, 3));
	}

	static public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		if (A[0] <= A[A.length - 1]) {
			return search(A, 0, A.length - 1, target);
		} else {
			int start = 0;
			int end = A.length - 1;
			int mid = (start + end) / 2;
			while (true) {

				if (A[mid] > A[start]) {
					int result = search(A, start, mid, target);
					if (result != -1) {
						return result;
					}
					start = mid;
				} else {
					end = mid;
				}
				mid = (start + end) / 2;
				if (mid == start) {
					break;
				}
			}
			if (A[A.length - 1] >= target) {
				return search(A, mid + 1, A.length - 1, target);

			}
			return search(A, 0, mid, target);

		}

	}

	static int search(int[] A, int start, int end, int target) {

		if (A[start] > target || A[end] < target) {
			return -1;
		}
		while (start <= end) {
			if (start == end) {
				return A[end] == target ? end : -1;
			}
			if (start + 1 == end) {
				if (A[start] == target) {
					return start;
				}
				if (A[end] == target) {
					return end;
				}
				return -1;
			}
			int mid = (start + end) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return -1;
	}

}
