public class Divide {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1(8, 7);
		f1(-8, 7);
		f1(-8, -7);
		f1(8, -7);
		System.out.println();
		f2(8, 7);
		f2(-8, 7);
		f2(-8, -7);
		f2(8, -7);

		System.out.println();
		f1(232, 33);
		f1(-232, 33);
		f1(-233, -33);
		f1(232, -33);
		System.out.println();
		f2(232, 33);
		f2(-232, 33);
		f2(-233, -33);
		f2(232, -33);
	}

	static void f1(int numerator, int denominator) {
		boolean isNegative = (((numerator ^ denominator) & (1 << 31)) != 0);
		// System.out.println(isNegative);
		int coef = isNegative ? -1 : 1;
		int remainder = numerator;
		int factor = 0;
		while (!(remainder < Math.abs(denominator) && remainder >= 0)) {
			factor++;
			remainder -= coef * denominator;
		}
		System.out.print(factor * coef);
		System.out.println(" , " + remainder);
	}

	static void f2(int numerator, int denominator) {
		boolean isNegative = (((numerator ^ denominator) & (1 << 31)) != 0);
		// System.out.println(isNegative);
		int coef = isNegative ? -1 : 1;
		int remainder = numerator;
		int factor = 0;
		int digit = 0;
		while (!(remainder < Math.abs(denominator) && remainder >= 0)) {

			int remainder_temp = remainder - coef * denominator * (1 << digit);
			if (Math.abs(remainder_temp) >= Math.abs(numerator)) {
				digit = 0;
			} else {
				remainder = remainder_temp;
				factor += (1 << digit);
				digit++;
			}

		}
		System.out.print(factor * coef);
		System.out.println(" , " + remainder);
	}
}
