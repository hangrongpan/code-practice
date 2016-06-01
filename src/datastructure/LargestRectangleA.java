package datastructure;

/**
 * Very naive brute force O(n2), might be TLE issue.
 * 
 * @author hpan
 *
 */
public class LargestRectangleA {
	/**
	 * @param height:
	 *            A list of integer
	 * @return: The area of largest rectangle in the histogram
	 */
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int size = height.length;
		int[] min = new int[size];
		int largestArea = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				// calculate the min[j]
				if (j == i) {
					min[j] = height[j];
				} else {
					min[j] = Math.min(height[j], min[j - 1]);
				}
				int tempArea = min[j] * (j - i + 1);
				largestArea = Math.max(tempArea, largestArea);
			}
		}
		return largestArea;
	}
}
