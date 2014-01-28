import java.util.ArrayList;

public class SimplifyPath {

	/**
	 * Given an absolute path for a file (Unix-style), simplify it.
	 * 
	 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", =>
	 * "/c"
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String simplifyPath(String path) {
		ArrayList<String> result = new ArrayList<String>();
		int pre = 0;
		int index = path.indexOf("/", pre + 1);
		while (true) {
			String s;
			if (index > 0) {
				s = path.substring(pre + 1, index);
			} else {
				s = path.substring(pre + 1);
			}

			if (s.equals("..") && !result.isEmpty()) {
				result.remove(result.size() - 1);
			} else if (!s.equals(".") && !s.isEmpty()) {
				result.add(s);
			}
			if (index < 0) {
				break;
			}
			pre = index;
			index = path.indexOf("/", pre + 1);

		}

		StringBuilder sb = new StringBuilder();
		for (String r : result) {
			sb.append("/");
			sb.append(r);
		}
		if (sb.length() == 0) {
			return "/";
		}
		return sb.toString();
	}

}
