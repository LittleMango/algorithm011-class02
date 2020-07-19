import java.util.*;

public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        List<List<Integer>> list = new ArrayList<>();

        while (!deque.isEmpty()) {
            int n = deque.size();
            List<Integer> child = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = deque.pollFirst();
                child.add(node.val);
                if (node.left != null) {
                    deque.offerLast(node.left);
                }
                if (node.right != null) {
                    deque.offerLast(node.right);
                }
            }
            list.add(child);
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
