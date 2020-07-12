import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution98 {

    public static void main(String[] args) {
        /**
         * 前序遍历 preorder = [3,9,20,15,7]
         * 中序遍历 inorder = [9,3,15,20,7]
         * [10,5,15,null,null,6,20]
         */
        Solution98 solution105 = new Solution98();
        TreeNode node10 = new TreeNode(-2147483648);
        TreeNode node15 = new TreeNode(2147483647);
        node10.right = node15;

        boolean isSearchTree = solution105.isValidBST(node10);
        System.out.println("isSearchTree:" + isSearchTree);
    }

    private ArrayList<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        // 中序记录
        validBST(root);
        // n次遍历看看是不是单调递增的
        if (!list.isEmpty()) {
            int left = list.get(0);
            for (int i = 1; i < list.size(); ++i) {
                if (list.get(i) > left) {
                    left = list.get(i);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public void validBST(TreeNode root) {
        if (root == null) {
            return;
        }
        validBST(root.left);
        list.add(root.val);
        validBST(root.right);
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