package leetcode8;

class MaxRec_85 {
	public int solution(char[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[] heights = new int[col];
		int maxArea = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == '0') {
					heights[j] = 0;
				} else {
					heights[j] += 1;
				}
			}
			maxArea = Math.max(maxArea, largestRec(heights));
		}
		return maxArea;
	}

	private int largestRec(int[] heights) {
		// implementation code
		return 0;
	}
}