package binarysearch;

class ArrayReader {
	public int get(int index) {
		// this is just a test number
		return -1;
	}
}

/**
 * Find first position == target in the big sorted array, otherwise return -1
 * 
 * @author hpan
 *
 */
public class SearchInABigArray {
	public int searchBigArray(ArrayReader reader, int target) {
		int index = 1;
		// find the general scope of the target
		while (reader.get(index) < target && reader.get(index) != -1) {
			index *= 2;
		}
		int left = 0;
		int right = index - 1;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (reader.get(index) != -1 && reader.get(index) < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (reader.get(left) == target) {
			return left;
		}
		if (reader.get(right) == target) {
			return right;
		}
		return -1;
	}
}
