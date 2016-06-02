package leetcode3;

class SearchInsert_35 {
	public int searchInseart(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid;
			} else if (nums[mid] > target) {
				right = mid;
			} else {
				return mid;
			}
		}
		if (nums[left] >= target) {
			return left;
		}
		if (nums[right] >= target) {
			return right;
		}
		return right + 1;
	}
}