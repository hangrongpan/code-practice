package leetcode10;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int val) {
		this.val = val;
		left = null;
		right = null;
	}
}

class MaxDepth_104 {
	public int solution(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// divide 
		int left = solution(root.left);
		int right = solution(root.right);
		// conquer
		return Math.max(left, right) + 1;
	}
}