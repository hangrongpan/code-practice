package binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {
	// left -> root -> right
	public ArrayList<Integer> inOrder(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.empty()) {
			// make sure left to the leaf
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			// root
			cur = stack.peek();
			stack.pop();
			result.add(cur.val);
			// right at last
			cur = cur.right;
		}
		return result;
	}

}

