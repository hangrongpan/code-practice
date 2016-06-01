package binarysearch;

public class FindMinInRotatedSortedArray {
	public int findMinInRotatedArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0;
		int right = nums.length - 1;
		int target = nums[nums.length - 1];

		// the rotation breaks this continuously increasing line.
      // it is similar to peak element, only reverse of that problem...
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				right = mid;
			} else {
				left = mid;
			}
		}

		if (nums[left] <= target) {
			return nums[left];
		} else {
			return nums[right];
		}
	}
}
