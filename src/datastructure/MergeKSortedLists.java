package datastructure;

import java.util.List;

import linkedlist.ListNode;

public class MergeKSortedLists {
	
	public ListNode mergeKSortedLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		
		int size = lists.size();
		return helper(lists, 0, size - 1);
	}

	// binary search method
	private ListNode helper(List<ListNode> lists, int start, int end) {
		if (start == end) {
			return lists.get(start);
		}
		int mid = (start + end) / 2;
		ListNode left = helper(lists, start, mid);
		ListNode right = helper(lists, mid + 1, end);
		return mergeTwoSortedLists(left, right);
	}

	private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode dummy = new ListNode(-1);
		ListNode l3 = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				l3.next = l1;
				l1 = l1.next;
			} else {
				l3.next = l2;
				l2 = l2.next;
			}
			l3 = l3.next;
		}

		if (l1 != null) {
			l3.next = l1;
		}
		if (l2 != null) {
			l3.next = l2;
		}

		return dummy.next;
	}
}
