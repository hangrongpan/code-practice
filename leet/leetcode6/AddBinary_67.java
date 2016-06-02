package leetcode6;

// 基本题目，熟悉掌握
public class AddBinary_67 {
	public String solution(String a, String b) {
		int m = a.length();
		int n = b.length();
		int maxLen = Math.max(m, n);
		int carry = 0;
		String result = "";
		for (int i = 0; i < maxLen; i++) {
			int p = 0, q = 0;
			if (i < m) {
				p = a.charAt(m - 1 - i);
			} else {
				p = 0;
			}
			if (i < n) {
				q = b.charAt(n - 1 - i);
			} else {
				q = 0;
			}
			int tmp = p + q + carry;
			carry = tmp / 2;
			result += tmp % 2;
		}

		if (carry == 0) {
			return result;
		}
		return "1" + result;
	}
}
