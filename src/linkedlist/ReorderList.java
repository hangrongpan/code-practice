package linkedlist;

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode mid = findMid(head);
		ListNode newHead = reverseLinkedList(mid.next);
		mid.next = null;
		mergetTwoLists(head, newHead);
	}
	
	private ListNode findMid(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	// 可以写成不return head的 merge， 直接把l1和l2拼接
	private void mergetTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return;
		}
		int index = 0;
		ListNode pre = new ListNode(-1);
		while (l1 != null && l2 != null) {
			if (index % 2 == 0) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
			index++;
		}
		if (l1 == null) {
			pre.next = l2;
		} 
		if (l2 == null) {
			pre.next = l1;
		}
	}
	
	private ListNode reverseLinkedList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		head.next = null;
		return pre;
	}
 }
