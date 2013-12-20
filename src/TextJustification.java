import java.util.ArrayList;

public class TextJustification {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> results = fullJustify(new String[] { "This", "is",
				"an", "example", "of", "text", "justification." }, 16);
		for (String result : results) {
			System.out.println(result);
		}

		results = fullJustify(new String[] { "" }, 0);
		for (String result : results) {
			System.out.println(result);
		}

	}

	static public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		if (words == null || words.length == 0) {
			return result;
		}
		for (int i = 0; i < words.length;) {
			int totalLen = 0;
			int j = i;
			boolean isLastLine = true;
			for (; j < words.length; j++) {
				if (totalLen + words[j].length() + j - i <= L) {
					totalLen += words[j].length();
				} else {
					j--;
					isLastLine = false;
					break;
				}

			}
			if (j == words.length) {
				j--;
			}
			StringBuilder sb = new StringBuilder();
			if (j - i == 0) {
				sb.append(words[i]);
				sb.append(new String(new char[L - words[i].length()]).replace(
						"\0", " "));
				result.add(sb.toString());
			} else {

				int interSpaceSize = (L - totalLen) / (j - i);
				int rightSpaceSize = (L - totalLen) % (j - i);
				if (isLastLine) {
					interSpaceSize = 1;
					rightSpaceSize = L - totalLen - (j - i);
				}
				for (int k = i; k < j; k++) {
					sb.append(words[k]);
					sb.append(new String(new char[interSpaceSize]).replace(
							"\0", " "));
				}
				sb.append(words[j]);
				sb.append(new String(new char[rightSpaceSize]).replace("\0",
						" "));
				result.add(sb.toString());

			}
			i = j + 1;

		}
		return result;

		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.

	}

}
