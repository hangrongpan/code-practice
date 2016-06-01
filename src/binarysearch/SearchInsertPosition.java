package binarysearch;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int left = 0;
		int right = A.length - 1;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (A[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (A[left] >= target) {
			return left;
		}
		if (A[right] >= target) {
			return right;
		}
		//ex: [1,2] target = 100 -> left = 1, right = 1 -> return 1 + 1 = 2
		return right + 1;
	}
}
