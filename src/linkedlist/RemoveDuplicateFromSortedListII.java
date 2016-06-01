package linkedlist;

public class RemoveDuplicateFromSortedListII {
	public ListNode removeDuplicateFromSortedListII(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		while (pre.next != null && pre.next.next != null) {
			if (pre.next.val == pre.next.next.val) {
				int tmp = pre.next.val;
				while (pre.next != null && pre.next.val == tmp) {
					pre.next = pre.next.next;
				}
			} else {
				pre = pre.next;
			}
		}
		return dummy.next;
	}
}
