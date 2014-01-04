public class Candies {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int candy(int[] ratings) {
		int[] candies = new int[ratings.length];
		for (int i = 0; i < ratings.length; i++) {
			if ((i + 1 >= ratings.length || ratings[i] <= ratings[i + 1])
					&& (i - 1 < 0 || ratings[i - 1] >= ratings[i])) {
				candies[i] = 1;
			}
		}

		for (int i = 0; i < ratings.length; i++) {
			if ((i - 1 >= 0 && ratings[i - 1] < ratings[i])) {
				candies[i] = Math.max(candies[i], candies[i - 1] + 1);
			}
		}
		int total = 0;
		for (int i = ratings.length - 1; i >= 0; i--) {
			if ((i + 1 < ratings.length && ratings[i] > ratings[i + 1])) {
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
			total += candies[i];
		}
		return total;
	}

}
