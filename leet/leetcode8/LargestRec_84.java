package leetcode8;

import java.util.*;


class LargetRec_84 {
	public int solution(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		int maxArea = 0; 
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < heights.length; i++) {
			while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
				int t = stack.pop();
				int width = stack.isEmpty() ? i: (i - stack.peek() - 1);
				int curArea = heights[t] * width;
				maxArea = Math.max(curArea, maxArea);
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			int t = stack.pop();
			int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
			int curArea = heights[t] * width;
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}
}