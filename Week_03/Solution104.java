import java.util.ArrayList;

public class Solution104 {

    public static void main(String[] args) {
        /**
         * 前序遍历 preorder = [3,9,20,15,7]
         * 中序遍历 inorder = [9,3,15,20,7]
         * [10,5,15,null,null,6,20]
         */
        Solution104 solution105 = new Solution104();
        TreeNode node10 = new TreeNode(-2147483648);
        TreeNode node15 = new TreeNode(2147483647);
        node10.right = node15;
        int count = solution105.maxDepth(node10);
        System.out.println("count:" + count);
    }

    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        maxDepth(1, root);
        return maxDepth;
    }

    public void maxDepth(int count, TreeNode root) {
        if (root == null) {
            if (count - 1 > maxDepth) {
                maxDepth = count - 1;
            }
            return;
        }

        maxDepth(count + 1, root.left);
        maxDepth(count + 1, root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}