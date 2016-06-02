package leetcode8;

class RemoveDuplicate_83 {
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
			next = null;
		}
	}
	
	public ListNode solution(ListNode head) {
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}
}