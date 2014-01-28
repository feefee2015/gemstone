import java.util.ArrayList;
import java.util.Arrays;

public class RestoreIP {

	/**
	 * Given a string containing only digits, restore it by returning all
	 * possible valid IP address combinations.
	 * 
	 * For example: Given "25525511135",
	 * 
	 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> result = restoreIpAddresses("010010");
		System.out.println(result);

	}

	static public ArrayList<String> restoreIpAddresses(String s) {
		int len = s.length();
		if (len < 4 || len > 12) {
			return new ArrayList<String>();
		}
		ArrayList[][][] result = new ArrayList[len][len][4];
		for (int dotnum = 0; dotnum <= 3; dotnum++)
			for (int start = 0; start < len; start++)
				for (int end = start; end < len; end++) {
					String sub = s.substring(start, end + 1);
					if (dotnum == 0) {
						if (end > start + 2) {
							continue;
						}
						int val = Integer.parseInt(sub);
						if (val >= 0 && val <= 255
								&& (!sub.startsWith("0") || sub.length() == 1)) {

							result[start][end][dotnum] = new ArrayList<String>(
									Arrays.asList(new String[] { sub }));
						}

					} else {
						result[start][end][dotnum] = new ArrayList<String>();
						for (int j = start; j < end; j++) {
							if (result[start][j][0] != null
									&& result[start][j][0].size() > 0
									&& result[j + 1][end][dotnum - 1] != null
									&& result[j + 1][end][dotnum - 1].size() > 0) {

								for (Object st : result[j + 1][end][dotnum - 1]) {
									result[start][end][dotnum]
											.add(result[start][j][0].get(0)
													+ "." + st);
								}
							}
						}
					}
				}
		return result[0][s.length() - 1][3];
	}

}
