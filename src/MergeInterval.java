import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeInterval {
	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}
	}

	static class InterValComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval arg0, Interval arg1) {
			// TODO Auto-generated method stub
			int val = arg0.start - arg1.start;
			if (val != 0) {
				return val;
			}
			return arg0.end - arg1.end;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new InterValComparator());
		ArrayList<Interval> result = new ArrayList<Interval>();

		Interval temp = null;
		for (Interval interval : intervals) {
			if (temp == null) {
				temp = interval;
			} else {
				if (temp.end < interval.start) {
					result.add(temp);
					temp = interval;
				} else {
					temp.end = Math.max(interval.end, temp.end);
				}
			}
		}
		if (temp != null) {
			result.add(temp);
		}
		return result;
	}
}
