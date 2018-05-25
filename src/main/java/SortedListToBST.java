package main.java;

import org.junit.Test;

public class SortedListToBST {
    private ListNode list;

    public TreeNode sortedListToTree(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p!= null) {
            p = p.next;
            n++;
        }
        return sortedListToTree(0, n - 1);
    }

    public TreeNode sortedListToTree(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = sortedListToTree(start, mid - 1);
        if (left != null)
            System.out.println("Left: " + left.value);
        TreeNode root = new TreeNode(list.value);
        System.out.println("Root: " + root.value);
        root.left = left;
        list = list.next;
        TreeNode right = sortedListToTree(mid + 1, end);
        if (right != null)
            System.out.println("Right: " + right.value);
        root.right = right;
        return root;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 1; i <= 6; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        list = head;
        sortedListToTree(head);
    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;
    public TreeNode(int value) {
        this.value = value;
    }
}

class ListNode {
    int value;
    ListNode next;
    public ListNode(int value) {
        this.value = value;
    }
}
