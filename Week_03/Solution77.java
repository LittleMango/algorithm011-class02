import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution77 {

    public static void main(String[] args) {
        Solution77 solution = new Solution77();
        solution.combine(4, 2);
    }

    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        backtrack(1, new LinkedList<>());
        return output;
    }

    private void backtrack(int first, LinkedList<Integer> curr) {
        // 如果符合目标，则记录，并且退出
        if (curr.size() == k) {
            output.add(new LinkedList<>(curr));
            return;
        }

        for (int i = first; i < n + 1; i++) {
            // 先加入元素
            curr.add(i);
            // 进行下一步递归
            backtrack(i + 1, curr);
            // 回溯，删除下探的节点
            curr.removeLast();
        }
    }
}