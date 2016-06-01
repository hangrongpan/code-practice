package linkedlist;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		// 1. detect cycle
		while (true) {
			if (fast == null || fast.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		// 2. find the cycle join point
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
