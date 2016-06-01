package binarysearch;

public class SearchAMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int left = 0;
		int right = row * col - 1;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			int r = mid / col;
			int c = mid % col;
			int number = matrix[r][c];
			if (number < target) {
				left = mid;
			} else if (number > target) {
				right = mid;
			} else {
				return true;
			}
		}
		if (matrix[left/col][left%col] == target) {
			return true;
		}
		if (matrix[right/col][right%col] == target) {
			return true;
		}
		return false;
	}
}
