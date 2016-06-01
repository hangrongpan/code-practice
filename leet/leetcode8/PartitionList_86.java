package leetcode8;

class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
		next = null;
	}
}

class PartitionList_86 {
	public ListNode solution(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy1 = new ListNode(-1);
		ListNode p1 = dummy1;
		ListNode dummy2 = new ListNode(-1);
		ListNode p2 = dummy2;
		while (head != null) {
			if (head.val < x) {
				p1.next = head;
				p1 = p1.next;
			} else {
				p2.next = head;
				p2 = p2.next;
			}
			head =head.next;
		}
		p1.next = dummy2.next;
		p2.next = null;
		return p1;
	}
}