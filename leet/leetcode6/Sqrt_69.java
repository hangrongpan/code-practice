package leetcode6;

public class Sqrt_69 {
	public int solution(int x) {
		if (x < 0) {
			return -1;
		}
		long left = 1;
		long right = x;
		while (left + 1 < right) {
			long mid = left + (right - left) / 2;
			if (mid * mid <= x) {
				right = mid;
			} else {
				left = mid;
			}
		}
		if (right * right <= x) {
			return (int) right;
		}
		return (int) left;
	}
}
