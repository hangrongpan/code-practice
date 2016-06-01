package linkedlist;

public class RemoveNthFromEnd {
	public ListNode removeNthFromList(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = head;
		for (int i = 0; i < n; i++) {
			if (fast == null) {
				return null;
			}
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		// worst case is slow.next.next = null (when n = 1, it is removing the last node from the list)
		slow.next = slow.next.next;
		return dummy.next;
	}
}
