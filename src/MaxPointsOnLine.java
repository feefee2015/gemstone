import java.util.HashMap;

public class MaxPointsOnLine {

	static class Line {
		Point a;
		Point b;

		public Line(Point a, Point b) {
			this.a = a;
			this.b = b;

		}

		@Override
		public int hashCode() {
			int deltax = a.x - b.x;
			int deltay = a.y - b.y;
			if (deltax == 0) {
				return 0;
			} else {
				return deltay / deltax;
			}
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Line) {
				Line line = (Line) o;
				return online(line.a) && online(line.b);

			}
			return false;
		}

		boolean online(Point p) {
			int c1 = a.y - b.y;
			int c2 = b.x - a.x;
			int c3 = (c1 * a.x + c2 * a.y) * (-1);
			return c1 * p.x + c2 * p.y + c3 == 0;
		}
	}

	static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxPoints(new Point[] { new Point(0, 0),
				new Point(-1, -1), new Point(2, 2) }));

	}

	public static int maxPoints(Point[] points) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (points == null || points.length == 0) {
			return 0;
		}
		if (points.length == 1) {
			return 1;
		}
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			if (max > points.length - i) {
				break;
			}
			HashMap<Line, Integer> counter = new HashMap<Line, Integer>();
			int dups = 0;
			int localMax = 0;
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					dups++;
					continue;
				}
				Line l = new Line(points[i], points[j]);
				int val = 0;
				if (counter.containsKey(l)) {
					val = counter.get(l) + 1;
				} else {
					val = 1;
				}
				if (val > localMax) {
					localMax = val;
				}
				counter.put(l, val);
			}
			if (max < 1 + localMax + dups) {
				max = 1 + localMax + dups;
			}
		}
		return max;
	}

}
