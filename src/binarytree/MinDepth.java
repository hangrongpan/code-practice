package binarytree;

import org.junit.Assert;
import org.junit.Test;

public class MinDepth {

    // Recursion
    public int minDepth(TreeNode node) {
        return minDepth(node, false);
    }

    private int minDepth(TreeNode root, boolean hasNeighbor) {
        if (root == null) {
            // 如果有边缘节点，走当前结点。
            return hasNeighbor ? Integer.MAX_VALUE : 0;
        }
        int leftRoute = minDepth(root.left, root.right != null);
        int rightRoute = minDepth(root.right, root.left !=null);
        return 1 + Math.min(leftRoute, rightRoute);
    }

    @Test
    public void test() {
        // case 1
        TreeNode root = new TreeNode(0);
        Assert.assertEquals(1, minDepth(root));

        // Case 2
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(2);
        Assert.assertEquals(2, minDepth(root));
    }
}
