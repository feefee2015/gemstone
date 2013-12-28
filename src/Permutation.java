import java.util.Date;
import java.util.HashSet;

public class Permutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date t = new Date();
		System.out.println(getPermutation(9, 84540));
		System.out.println(new Date().getTime() - t.getTime());
		t = new Date();
		System.out.println(getPermutation0(9, 84540));
		System.out.println(new Date().getTime() - t.getTime());

	}

	public static String getPermutation(int n, int k) {
		boolean[] used = new boolean[n];
		Integer counter = 0;
		StringBuilder sb = new StringBuilder();
		int b = f(n, k, counter, new HashSet<Integer>(), sb);
		if (b == -1) {
			return sb.toString();
		}
		return null;

	}

	static int f(int n, int k, Integer counter, HashSet<Integer> used,
			StringBuilder sb) {
		if (used.size() == n) {
			return counter + 1 == k ? -1 : counter + 1;
		}

		for (int i = 1; i <= n; i++) {

			if (!used.contains(i)) {

				sb.append(i);
				used.add(i);
				counter = f(n, k, counter, used, sb);
				if (counter == -1) {
					break;
				}
				used.remove(i);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		return counter;

	}

	static int calculate(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * calculate(n - 1);
	}

	public static String getPermutation0(int n, int k) {
		int[] result = getCoeff(n, k);
		int[] offset = new int[n];
		for (int i = 0; i < offset.length; i++) {
			offset[i] = 0;
		}
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> used = new HashSet<Integer>();
		int total = 0;
		for (int i = result.length - 1; i >= 0; i--) {
			int val = result[i];
			for (; val <= n; val++) {
				if (!used.contains(val) && val - offset[val - 1] == result[i]) {
					break;
				}
			}

			sb.append(val);
			used.add(val);
			total += val;
			for (int j = val + 1; j <= n; j++) {
				offset[j - 1] = offset[j - 1] + 1;
			}

		}
		int last = (1 + n) * n / 2 - total;
		sb.append(last);
		return sb.toString();

	}

	/**
	 * calculate the n-1 coefficients (Xn - 1) * (n-1)! + (Xn-1 -1)* (n-2)! +..+
	 * (X2-1)*1!+1 = k or (Xn - 1) * (n-1)! + (Xn-1 -1)* (n-2)! +..+ (X2-1)*1! =
	 * k-1 Xi = Pn - (number of digits to the left of Pn in the final string
	 * that is smaller than Pn). Pn is the actual nth digit (from right) in the
	 * final permutated result of getPermutation0(n,k). It can be proven (with
	 * induction) that Xi<=i.
	 * 
	 * If both side of the equation is devided by (n-1)!, then Xn - 1 + {(Xn-1
	 * -1)* (n-2)! +..+ (X2-1)*1!}/(n-1)! = (k-1)/(n-1)! With Xi<=i we can infer
	 * {(Xn-1 -1)* (n-2)! +..+ (X2-1)*1!}/(n-1)! <1 , so Xn-1 = (k-1)/(n-1)!
	 * with remainder ignored. With this we can get Xn, Xn-1....X2. Since the
	 * result for getPermutation0 is apparently deterministic with the
	 * permutation rule, we can in turn iteratively compute the actual permu
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public static int[] getCoeff(int n, int k) {
		int[] result = new int[n - 1];
		for (int i = n - 1 - 1; i >= 0; i--) {
			int mult = calculate(i + 1);
			result[i] = (k - 1) / mult + 1;
			k -= (result[i] - 1) * mult;
		}
		return result;
	}

}
