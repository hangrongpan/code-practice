package binarysearch;

/**
 * Total n version, starting form one of them is bad version. Find it.
 * 
 * @author hangrongpan
 * 
 */
public class FirstBadVersion {
	public int firstBadVersion(int n) {
		if (n == 0) {
			return -1;
		}
		int left = 0;
		int right = n;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (SVNRepo.isBadVersion(mid)) {
				right = mid;
			} else {
				left = mid;
			}
		}
		if (SVNRepo.isBadVersion(left)) {
			return left;
		}
		return right;
	}
}

class SVNRepo {
	public static boolean isBadVersion(int k) {
		// black box function
		return false;
	}
}