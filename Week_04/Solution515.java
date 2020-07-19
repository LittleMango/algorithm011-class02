import java.util.*;

public class Solution515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode child = deque.pollFirst();
                max = Math.max(max, child.val);
                if (child.left != null) {
                    deque.offerLast(child.left);
                }
                if (child.right != null) {
                    deque.offerLast(child.right);
                }
            }
            list.add(max);
        }
        return list;
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
