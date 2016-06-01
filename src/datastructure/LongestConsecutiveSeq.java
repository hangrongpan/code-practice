package datastructure;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
	public int longestConsecutiveSequcense(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int maxLen = 1;
		Set<Integer> set = new HashSet<Integer>();
		for (int n : nums) {
			set.add(n);
		}
		for (int n : nums) {
			int tmp = n;
			set.remove(n);
			int count = 1;
			while (set.contains(tmp + 1)) {
				set.remove(tmp + 1);
				tmp++;
				count++;
			}
			tmp = n;
			while (set.contains(tmp - 1)) {
				set.remove(tmp - 1);
				tmp--;
				count++;
			}
			maxLen = Math.max(count, maxLen);
		}
		return maxLen;
	}
}
