package linkedlist;

import linkedlist.ListNode;

public class ReverseLinkedList {
	
	/* use three pointer to slide through the linked list.
	*
	*   null  head  head.next
	*  tail  <- p <- q 
	*
	*/

	public ListNode reverseLinkedList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode tail = null;
		ListNode p = head;
		ListNode q = p.next;

		// when q = null, that mean it reached the end of current linked list
		while (q != null) {
			ListNode temp = q.next;
			p.next = tail;
			q.next = p;

			tail = p;
			p = q;
			q = temp;
		}
		return q;
	}

}