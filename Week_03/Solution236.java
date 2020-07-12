import java.util.HashMap;
import java.util.HashSet;

public class Solution236 {

    public static void main(String[] args) {
        Solution236 solution236 = new Solution236();
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        node2.left = node7;
        node2.right = node4;

        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        node5.left = node6;
        node5.right = node2;

        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1);
        node1.left = node0;
        node1.right = node8;

        TreeNode node3 = new TreeNode(3);
        node3.left = node5;
        node3.right = node1;

        System.out.println(solution236.lowestCommonAncestor(node3, node4, node7).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, map);
        HashSet<TreeNode> firstSet = new HashSet<>();
        TreeNode move = p;
        while (move != null) {
            firstSet.add(move);
            move = map.get(move);
        }
        // 寻找是否有相同的节点
        move = q;
        while (move != null) {
            if (firstSet.contains(move)) {
                return move;
            }
            move = map.get(move);
        }
        return null;
    }

    private void dfs(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        if (root != null) {
            if (root.left != null) {
                map.put(root.left, root);
            }
            if (root.right != null) {
                map.put(root.right, root);
            }
            dfs(root.left, map);
            dfs(root.right, map);
        }
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