/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
class Interval {
	int start;
	int end;

	int compare(Interval that) {
		if (this.end < that.start) {
			return -1;
		}
		if (this.start > that.end) {
			return 1;
		}
		return 0; // overlapping
	}

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	Interval merge(Interval that) {
		return new Interval(Math.min(this.start, that.start), Math.max(
				this.end, that.end));
	}

	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}
}

public class Overlapping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] a = new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 },
				{ 12, 16 } };
		Interval[] it = new Interval[a.length];
		for (int i = 0; i < a.length; i++) {
			it[i] = new Interval(a[i][0], a[i][1]);
		}
		f(it, new Interval(4, 9));

	}

	static void f(Interval[] original, Interval entry) {
		boolean processed = false;
		for (int i = 0; i < original.length; i++) {
			if (processed) {
				System.out.print(original[i] + " ");
			} else {
				if (entry.compare(original[i]) == -1) {
					System.out.print(entry + " ");
					System.out.print(original[i] + " ");
					processed = true;
				} else if (entry.compare(original[i]) == 0) {
					entry = entry.merge(original[i]);

				} else {
					System.out.print(original[i] + " ");
				}
			}
		}
		if (!processed) {
			System.out.print(entry);
		}
	}

}
