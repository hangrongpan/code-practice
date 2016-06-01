package linkedlist;

/**
 * 1. in-order traversal
 * 2. compute the length of list
 * 3. final condition
 * 4. break point
 * @author hangrongpan
 *
 */
public class ConvertSortedListToBST {
	private ListNode current;
	public TreeNode convert(ListNode head) {
		if (head == null) {
			return null;
		}
		int len = 0;
		ListNode tmp = head;
		while (tmp != null) {
			len++;
			tmp = tmp.next;
		}
		current = head;
		return helper(0, len - 1);
	}
	
	/**
	 * 1. 先递归左子树，一直到leaf节点
	 * 2. 生成左边节点后，移动链表指针
	 * @param start
	 * @param end
	 * @return
	 */
	private TreeNode helper(int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode left = helper(start, mid - 1);
		TreeNode root = new TreeNode(current.val);
		current = current.next;
		root.left = left;
		TreeNode right = helper(mid + 1, end);
		root.right = right;
		return root;
	}
}

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
}
