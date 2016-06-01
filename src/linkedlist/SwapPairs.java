package linkedlist;

import linkedlist.ListNode;

public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		// Using two pointers, pointer 1 is always ahead of pointer 2.
		ListNode pointer1 = dummyHead;
		ListNode pointer2 = head;

		while (pointer2 != null && pointer2.next != null) {
			// temporary store the next next node
			ListNode nextStart = pointer2.next.next;
			pointer2.next.next = pointer2;
			pointer1.next = pointer2.next;
			pointer2.next = nextStart;

			pointer1 = pointer2;
			pointer2 = pointer2.next;
		}

		return dummyHead.next;
	}
}
