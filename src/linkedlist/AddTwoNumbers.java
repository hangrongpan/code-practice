package linkedlist;

import linkedlist.ListNode;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		// dummyHead references to the head of the new list which is used to
		// store the result linked
		// list.
		ListNode curr = dummyHead;
		int carry = 0;
		while (l1 != null|| l2 != null) {
			if (l1 != null) {
			    carry += l1.val;
			    l1 = l1.next;
			}
			if (l2 != null) {
			    carry += l2.val;
			    l2 = l2.next;
			}
			curr.next = new ListNode(carry % 10);
			carry /= 10;
			curr = curr.next;
		}
		if (carry == 1) {
		    curr.next = new ListNode(1);
		}
		return dummyHead.next;
	}

}
