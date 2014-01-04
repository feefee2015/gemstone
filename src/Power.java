public class Power {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Power p = new Power();
		System.out.println(p.pow(1.00001, 123456));

	}

	public double pow(double x, int n) {
		if (n == 0) {
			return 1.0d;
		}
		if (n > 0) {
			if (n % 2 == 0) {
				double d = pow(x, n / 2);
				return d * d;
			}
			double d = pow(x, (n - 1) / 2);
			return d * d * x;
		}
		return (1.0 / (pow(x, -1 * (n + 1)))) / x;

	}

}
