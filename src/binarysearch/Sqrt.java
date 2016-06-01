package binarysearch;

public class Sqrt {
	public int sqrt(int x) {
		if (x < 0) {
			return -1;
		}
		long left = 1;
		long right = x;
		while (left + 1 < right) {
			long mid = (left + right) / 2;
			if (mid * mid < x) {
				left = mid;
			} else if (mid * mid > x) {
				right = mid;
			} else {
				return (int) mid;
			}
		}
		
		if (right * right <= x) {
			return (int) right;
		} 
		else {
			return (int) left;
		}
	}
}
