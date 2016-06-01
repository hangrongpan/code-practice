package datastructure;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	DoubleListNode head;
	DoubleListNode end;
	int len;
	int capacity;
	Map<Integer, DoubleListNode> cache = new HashMap<Integer, DoubleListNode>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.len = 0;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			DoubleListNode latest = cache.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.val;
		}
		return -1;
	}

	public void set(int key, int val) {
		if (cache.containsKey(key)) {
			DoubleListNode old = cache.get(key);
			old.val = val;
			removeNode(old);
			setHead(old);
		} else {
			DoubleListNode newNode = new DoubleListNode(key, val);
			if (len < capacity) {
				len++;
			} else {
				removeNode(end);
				if (end != null) {
					end.next = null;
				}
			}
			setHead(newNode);
			cache.put(key, newNode);
		}
	}

	private void setHead(DoubleListNode node) {
		node.next = head;
		node.pre = null;
		if (head != null) {
			head.pre = node;
		}
		head = node;
		if (end == null) {
			end = node;
		}
	}

	private void removeNode(DoubleListNode node) {
		DoubleListNode cur = node;
		DoubleListNode pre = cur.pre;
		DoubleListNode next = cur.next;

		if (pre != null) {
			pre.next = next;
		} else {
			head = next;
		}

		if (next != null) {
			next.pre = pre;
		} else {
			end = pre;
		}
	}

}

class DoubleListNode {
	DoubleListNode pre;
	DoubleListNode next;
	int key;
	int val;

	public DoubleListNode(int k, int v) {
		this.key = k;
		this.val = v;
	}
}
