public class Divide {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(divide(-2147483648, 1));
		/*
		 * f1(8, 7); f1(-8, 7); f1(-8, -7); f1(8, -7); System.out.println();
		 * f2(8, 7); f2(-8, 7); f2(-8, -7); f2(8, -7);
		 * 
		 * System.out.println(); f1(232, 33); f1(-232, 33); f1(-233, -33);
		 * f1(232, -33); System.out.println(); f2(232, 33); f2(-232, 33);
		 * f2(-233, -33); f2(232, -33);
		 */
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

	static int f2(int numerator, int denominator) {
		if (numerator == 0) {
			return 0;
		}
		if (denominator == Integer.MIN_VALUE) {
			if (numerator == Integer.MIN_VALUE) {
				return 1;
			}
			return 0;
		}
		boolean isNegative = (((numerator ^ denominator) & (1 << 31)) != 0);
		// System.out.println(isNegative);
		int coef = isNegative ? -1 : 1;
		int remainder = numerator;
		int factor = 0;
		int digit = 0;
		while (remainder != 0 && (((numerator ^ remainder) & (1 << 31)) == 0)) {

			int remainder_temp = remainder - coef * (denominator << digit);
			// check if remainer still same sign as the numerator
			if (Math.abs(remainder_temp) > Math.abs(denominator)
					&& (((numerator ^ remainder_temp) & (1 << 31)) != 0)) {
				digit = 0;
			} else {
				remainder = remainder_temp;
				factor += (1 << digit);
				digit++;
			}

		}
		System.out.print(factor * coef);
		System.out.println(" , " + remainder);
		return factor * coef;
	}

	static int f0(int numerator, int denominator) {

		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);
		int remainder = numerator;
		int factor = 0;
		int digit = 0;
		while (!(remainder < denominator && remainder >= 0)) {

			int remainder_temp = remainder - (denominator << digit);
			if (remainder_temp < 0) {
				digit = 0;
			} else {
				remainder = remainder_temp;
				factor += (1 << digit);
				digit++;
			}

		}
		return factor;
	}

	static void f3(int numerator, int denominator) {
		boolean isNegative = (((numerator ^ denominator) & (1 << 31)) != 0);
		// System.out.println(isNegative);
		int coef = isNegative ? -1 : 1;
		int remainder = numerator;
		int factor = 0;
		int digit = 1;
		while (!(remainder < Math.abs(denominator) && remainder >= 0)) {

			int remainder_temp = remainder - coef * denominator * (digit);
			if (Math.abs(remainder_temp) >= Math.abs(numerator)) {
				digit = 1;
			} else {
				remainder = remainder_temp;
				factor += (digit);
				digit *= 10;
			}

		}
		System.out.print(factor * coef);
		System.out.println(" , " + remainder);
	}

	static boolean isDifferentSign(int x, int y) {
		return ((x ^ y) & (1 << 31)) != 0;
	}

	public static int divide(int numerator, int denominator) {
		if (numerator == 0) {
			return 0;
		}
		if (denominator == Integer.MIN_VALUE) {
			if (numerator == Integer.MIN_VALUE) {
				return 1;
			}
			return 0;
		}
		if (numerator != Integer.MIN_VALUE
				&& Math.abs(numerator) < Math.abs(denominator)) {
			return 0;
		}
		boolean isNegative = isDifferentSign(numerator, denominator);
		// System.out.println(isNegative);
		int coef = isNegative ? -1 : 1;
		int remainder = numerator;
		int factor = 0;
		int digit = 0;
		while ((remainder == Integer.MIN_VALUE || Math.abs(remainder) >= Math
				.abs(denominator)) && !isDifferentSign(numerator, remainder)) {

			int remainder_temp = remainder - coef * (denominator << digit);
			// check if remainer still same sign as the numerator
			if (remainder_temp != 0
					&& isDifferentSign(numerator, remainder_temp)) {
				digit = 0;
			} else {
				remainder = remainder_temp;
				factor += (1 << digit);
				digit++;
			}

		}
		// System.out.print(factor * coef);
		// System.out.println(" , " + remainder);
		return factor * coef;
	}
}
