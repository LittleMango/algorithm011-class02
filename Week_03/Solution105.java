import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class Solution105 {

    public static void main(String[] args) {
        /**
         * 前序遍历 preorder = [3,9,20,15,7]
         * 中序遍历 inorder = [9,3,15,20,7]
         */
        Solution105 solution105 = new Solution105();
        TreeNode node = solution105.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(node);
    }

    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 先构建节点，先序第一个节点就是了
        TreeNode root = new TreeNode(preorder[preorder_left]);

        // 找到该节点对应中序数组中的位置
        int rootIndex = indexMap.get(preorder[preorder_left]);

        // 确定两个数组的新边界
        // 先序开始：原本先序开始+1
        // 先序结束：原本先序+中序左树数量
        // 中序开始：原本中序开始
        // 中序结束：中序根节点-1
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + rootIndex - inorder_left,
                inorder_left, rootIndex - 1);

        // 先序开始：原本先序+1+中序左树数量
        // 先序结束：原本先序结束
        // 中序开始: 中序左树数量+1
        // 中序结束: 原本中序结束
        root.right = myBuildTree(preorder, inorder, preorder_left + 1 + rootIndex - inorder_left, preorder_right,
                rootIndex + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
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