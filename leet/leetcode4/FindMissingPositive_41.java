// 1. hard
// 2. O(n)
// 3. Keywords: First, Positive
// 4. Find relationship: index <-> value

package leetcode4;

class FindMissingPositive_41 {
	public int solution(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}
		for (int i = 0; i < nums.length; i++) {
			// keep swapping until value of array is compatible with the index
			while (nums[i] != i + 1) {
				if (nums[i] < 0 || nums[i] > nums.length || nums[i] == nums[nums[i] - 1]) {
					break;
				}
				int tmp = nums[i];
				nums[i] = nums[tmp - 1];
				nums[tmp - 1] = tmp;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i+1) {
				return i+1;
			}
		}
		return nums.length + 1;
	}
}