public class MedianSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianSortedArray msr = new MedianSortedArray();
		double d = msr.findMedianSortedArrays(new int[] { 4 }, new int[] { 1,
				2, 3, 5 });
		System.out.println(d);

	}

	public double findMedianSortedArrays(int A[], int B[]) {

		int len1 = A.length;
		int len2 = B.length;
		boolean odd = ((len1 + len2) % 2 != 0);

		int mid = (len1 + len2) / 2 + 1;

		// if odd: median = mid th
		// if even: median = mid-th + (mid-1)-th /2

		if (A.length == 0 || B.length > 0 && A[A.length - 1] <= B[0]) {
			if (odd) {
				if (mid > A.length) {
					return B[mid - A.length - 1];
				} else {
					return A[mid - 1];
				}
			} else {

				// mid-1
				int n1 = mid - 1 > A.length ? B[mid - A.length - 1 - 1]
						: A[mid - 1 - 1];
				// mid
				int n2 = mid > A.length ? B[mid - A.length - 1] : A[mid - 1];
				return (n1 + n2) / 2.0d;
			}

		}
		if (B.length == 0 || A.length > 0 && B[B.length - 1] <= A[0]) {
			return findMedianSortedArrays(B, A);
		}

		// choose index mid1 around mid point of A
		int mid1 = len1 / 2;

		int mid2 = mid - (mid1 + 1) - 1;
		if (mid2 < 0) {
			mid2++;
			mid1--;
		}
		int move = (len1 < len2 ? len1 : len2) / 2;

		while (mid1 >= 0 && mid2 >= 0) {
			if ((A[mid1] <= B[mid2] && (mid1 + 1 >= A.length || A[mid1 + 1] >= B[mid2]))
					|| (A[mid1] >= B[mid2] && (mid2 + 1 >= B.length || A[mid1] <= B[mid2 + 1])))
				break;

			int step = move / 2;
			if (step == 0) {
				step = 1;
			}
			if (A[mid1] <= B[mid2]) {
				mid1 += step;
				mid2 -= step;
			} else {
				mid1 -= step;
				mid2 += step;
			}
			move /= 2;
		}

		if (odd) {
			if (mid1 < 0) {
				return B[mid2];
			}
			if (mid2 < 0) {
				return A[mid1];
			}
			return A[mid1] < B[mid2] ? B[mid2] : A[mid1];
		}

		if (mid1 < 0) {
			return (B[mid2] + B[mid2 - 1]) / 2.0d;
		}
		if (mid2 < 0) {
			return (A[mid1] + A[mid1 - 1]) / 2.0d;
		}

		int next;
		if (A[mid1] >= B[mid2]) {

			if (mid1 - 1 < 0) {
				next = B[mid2];
			} else {
				next = A[mid1 - 1] > B[mid2] ? A[mid1 - 1] : B[mid2];
			}

			return (A[mid1] + next) / 2.0d;
		}

		if (mid2 - 1 < 0) {
			next = A[mid1];
		} else {
			next = A[mid1] > B[mid2 - 1] ? A[mid1] : B[mid2 - 1];
		}
		return (B[mid2] + next) / 2.0d;

	}

}
