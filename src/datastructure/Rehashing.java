package datastructure;

import linkedlist.ListNode;

/**
 * hash code function to generate the hash key for values.
 * 
 * @author hpan
 *
 */
public class Rehashing {
	public ListNode[] rehashing(ListNode[] hashtable) {
		if (hashtable.length == 0) {
			return new ListNode[0];
		}

		int size = 2 * hashtable.length;
		ListNode[] newTable = new ListNode[size];
		for (int i = 0; i < hashtable.length; i++) {
			ListNode cur = hashtable[i];
			while (cur != null) {
				int val = cur.val;
				if (val >= 0) {
					insert(newTable, val % size, val);
				} else {
					insert(newTable, (val % size + size) % size, val);
				}
				cur = cur.next;
			}
		}
		return newTable;
	}

	private void insert(ListNode[] table, int i, int val) {
		if (table[i] == null) {
			table[i] = new ListNode(val);
		} else {
			ListNode head = table[i];
			while (head.next != null) {
				head = head.next;
			}
			head.next = new ListNode(val);
		}
	}
}
