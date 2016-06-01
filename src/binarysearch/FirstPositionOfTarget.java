package binarysearch;

public class FirstPositionOfTarget {
	public int firstPosition(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (nums[left] < target) {
				left = mid;
			} else {
				right = mid;
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
