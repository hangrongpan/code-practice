package datastructure;

/**
 * A much better improved algorithm, but the worst case still O(n2). Prunting
 * all the unqualified cases before proceeding further.
 * 
 * Code detail link: http://blog.csdn.net/abcbc/article/details/8943485
 * 
 * @author hpan
 *
 */
public class LargestRectangleC {

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
		int largestArea = 0;
		for (int i = 0; i < size; i++) {
			for (int k = i + 1; k < size; k++) {
				// 这一步是为了保持直方图的单调调递增
				// Always use the peak point to the left as the right boundary
				// for the area calculation.
				if (height[k] < height[k - 1]) {
					i = k - 1;
					break;
				} else {
					i = k;
				}
			}
			int min = height[i];
			for (int j = i; j >= 0; j--) {
				// calculate the min[j]
				if (height[j] < min) {
					min = height[j];
				}
				int tempArea = min * (i - j + 1);
				largestArea = Math.max(tempArea, largestArea);
			}
		}
		return largestArea;
	}

}
