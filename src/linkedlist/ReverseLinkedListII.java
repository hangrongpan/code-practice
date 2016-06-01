package linkedlist;
/**
 * 短短几行，包含了很多的技术点和注意的点
 * @author hangrongpan
 *
 */
public class ReverseLinkedListII {
	public ListNode reverseLinkedListII(ListNode head, int m, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		for (int i = 1; i < m; i++) {
			pre = pre.next;
			cur = cur.next;
			if (cur == null) {
				return head;
			}
		}
		ListNode outerPre = pre;
		ListNode firstM = cur;
		for (int i = m; i <= n; i++) {
			if (cur == null) {
				return head;
			}
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		outerPre.next = pre;
		firstM.next = cur;
		return dummy.next;
	}
}
