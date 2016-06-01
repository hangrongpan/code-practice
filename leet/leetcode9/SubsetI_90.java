package leetcode9;

import java.util.*;

class SubsetI_90 {
	private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> items, int[] nums, int pos) {
		result.add(items);
		for (int i = pos; i < nums.length; i++) {
			items.add(nums[i]);
			helper(result, items, nums, i + 1);
			items.remove(items.size() - 1);
		}
	}

	private void helper2 (ArrayList<ArrayList<Integer>> result, ArrayList<Integer> items, int[] nums, int pos) {
		result.add(items);
		for (int i = pos; i < nums.length; i++) {
			if (i > pos && nums[i] == nums[i-1]) {
				continue;
			}
			items.add(nums[i]);
			helper(result, items, nums, i+1);
			items.remove(items.size() - 1);
		}
	}
}