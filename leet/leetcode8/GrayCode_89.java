package leetcode8;

import java.util.*;

class GrayCode_89 {
	public List<Integer> solution(int n) {
		// edge condition
		if (n == 0) {
			List<Integer> result = new ArrayList<Integer>();
			result.add(0);
			return result;
		}
		// recursion
		List<Integer> result = solution(n - 1);
		int addNumber = 1 << (n - 1);
		int originSize = result.size();
		for (int i = originSize - 1; i >= 0; i--) {
			// reverse order + addNumber
			result.add(result.get(i) + addNumber);
		}
		return result;
	}
}