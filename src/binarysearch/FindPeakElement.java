package binarysearch;

public class FindPeakElement {

	/**
	 * Define the peak element position i, so nums[i] > nums[i-1] and nums[i] >
	 * nums[i+1]
	 * We assume that there is at least one peak point in the array.
	 * ipad edit
	 * @param nums
	 * @return
	 */
	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length <= 2) {
			return -1;
		}
		
		int left = 0;
		int right = nums.length - 2;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			// 左右徘徊 ... 左边大，说明极点在左边
			if (nums[mid] < nums[mid - 1]) {
				right = mid;
			// 右边大，说明极点在右边
			} else if (nums[mid] < nums[mid + 1]) {
				left = mid;
			// 两边都不大，默认极点在右边 （later从右边先获取输出值）	
			} else {
				right = mid;
			}
		}
		if (nums[left] <= nums[right]) {
			return right;
		} else {
			return left;
		}
	}
}
