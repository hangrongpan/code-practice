package datastructure;

import java.util.Stack;

/**
 * Return the nth Ugly number starting from 1.
 * UN list example: 
 * 1, 2, 3, 5, 6, 8, 9
 * 
 * @author hpan
 *
 */
public class UglyNumberII {
	
	public int uglyNumberII(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();
		Stack<Integer> s5 = new Stack<Integer>();
		int h = 1;
		for (int i = 1; i < n; i++) {
			s2.push(h * 2);
			s3.push(h * 3);
			s5.push(h * 5);
			
			h = Math.min(Math.min(s2.peek(), s3.peek()), s5.peek());
			if (h == s2.peek()) {
				s2.pop();
			}
			if (h == s3.peek()) {
				s3.pop();
			}
			if (h == s5.peek()) {
				s5.pop();
			}
		}
		return h;
	}
}
