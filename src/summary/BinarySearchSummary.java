package summary;

/**
 * Current stage from Lintcode ladder: http://www.lintcode.com/en/ladder/1/
 * Created by Henry Pan on 6/5/2016.
 */
public class BinarySearchSummary {
    /**
     * 1. Search insert position. 二分法第一题
     * 先search, if found, return the position, if not, return the position it should be inserted.
     */
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (A[mid] < target) {
                left = mid;
            } else if (A[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (A[left] >= target) {
            return left;
        }
        if (A[right] >= target) {
            return right;
        }
        return right + 1;
    }

    /**
     * 2. search a 2D matrix
     * 主要要求的是如何把二维书转换为一维数
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // row is the first dimension
        int num_of_row = matrix.length;
        // col is the second dimension
        int num_of_col = matrix[0].length;
        int low = 0;
        int high = num_of_row * num_of_col -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int row_ind = mid / num_of_col;
            int col_ind = mid % num_of_col;
            // 中间点太大，高位移调中间点，总体表小
            if (matrix[row_ind][col_ind] > target) {
                high = mid - 1;
            // 中间点太小，地位移到中间点，总体表大
            } else if (matrix[row_ind][col_ind] < target) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 3. First position of target
     */
    public int firstPostion(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }

    /**
     * 4. Search in a big sorted array. (First index of target number)
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        int index = 1;

        while (reader.get(index - 1) < target && reader.get(index - 1) != -1) {
            // low = index - 1;
            index = index * 2;
        }
        int low = 0;
        int high = index - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) < target && reader.get(mid) != -1) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if (reader.get(low) == target) {
            return low;
        }
        if (reader.get(high) == target) {
            return high;
        }
        return -1;
    }

    interface ArrayReader {
        public int get(int index);
    }

    /**
     * 5. Find minimum in rotated sorted array
     */
    public int findMinInRotatedArray(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }
        //
        // l  \    / target (r)
        //     \  /
        //      \/
        //       min
        int start = 0;
        int end = num.length - 1;
        int target = num[num.length - 1];
        // find first element <= target
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (num[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (num[start] <= target) {
            return num[start];
        } else {
            return num[end];
        }
    }
}
