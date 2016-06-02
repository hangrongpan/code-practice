package leetcode8;

class RemoveDuplicateII_82 {
	public ListNode solution(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		while (pre.next != null && pre.next.next != null) {
			if (pre.next.val == pre.next.next.val) {
				int nextVal = pre.next.val;
				while (pre.next != null && pre.next.val == nextVal) {
					pre.next = pre.next.next;
				}
			} else {
				pre = pre.next;
			}
		}
		return dummy.next;
	}
}