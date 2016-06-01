package binarysearch;

public class SearchInRotatedArrays {
	public int searchInRotatedArrays(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < nums[right]) {
				if (target <= nums[right] && target > nums[mid]) {
					left = mid;
				} else {
					right = mid;
				}
			} else {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid;
				} else {
					left = mid;
				}
			}
		}
		if (nums[left] == target) {
			return left;
		}
		if (nums[right] == target) {
			return right;
		}
		return -1;
	}
}
