import java.util.ArrayList;

public class PascalTriangle2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> result = getRow(2);
		System.out.println(result);
		//
		// for (int i = 0; i < result.size(); i++) {
		// System.out.println(result.get(i));
		// }
	}

	static ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (rowIndex < 0) {
			return result;
		}
		int[] temp = new int[rowIndex + 1];
		int defer = 0;
		int current;
		int loop = 0;
		while (loop <= rowIndex) {
			for (int i = 0; i <= loop; i++) {
				if (i == 0) {
					temp[i] = 1;
				} else if (i < loop) {
					current = temp[i] + temp[i - 1];
					if (i - 1 >= 1) {
						temp[i - 1] = defer;
					}
					defer = current;
				} else {
					if (i - 1 >= 1) {
						temp[i - 1] = defer;
					}
					temp[i] = 1;
				}
			}
			loop++;
		}
		for (int i : temp) {
			result.add(i);
		}
		// result = new ArrayList(Arrays.asList(temp));
		return result;
	}

}
