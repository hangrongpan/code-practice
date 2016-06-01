package leetcode3;

import java.util.*;

class CombinationSum_39 {
	public ArrayList<ArrayList<Integer>> solution(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (candidates == null) {
			return result;
		}

		ArrayList<Integer> items = new ArrayList<Integer>();
		Arrays.sort(candidates);
		helper(result, candidates, target, 0, items);
		return result;
	}
	private void helper(ArrayList<ArrayList<Integer>> result, int[] candidates, int target, int start, ArrayList<Integer> items) {
		if (target < 0)
			return;
		if (target == 0) 
			result.add(items);
		for (int i = start; i < candidates.length; i++) {
			if (i > 0 && candidates[i] == candidates[i-1])
				continue;
			items.add(candidates[i]);
			helper(result, candidates, target - candidates[i], i, items);
			items.remove(items.size() - 1);
		}
	}

	private void helperII(ArrayList<ArrayList<Integer>> result, int[] candidates, int target, int start, ArrayList<Integer> items) {
		if (target < 0)
			return;
		if (target == 0) 
			result.add(items);
		for (int i = start; i < candidates.length; i++) {
			if (i > 0 && candidates[i] == candidates[i-1])
				continue;
			items.add(candidates[i]);
			helper(result, candidates, target - candidates[i], i + 1, items);
			items.remove(items.size() - 1);
		}
	}
}