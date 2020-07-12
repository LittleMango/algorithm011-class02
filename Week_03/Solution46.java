import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution46 {

    public static void main(String[] args) {
        Solution46 solution = new Solution46();
        List<List<Integer>> list = solution.permute(new int[]{1, 2, 3,});
        System.out.println(list.size());
    }

    private List<List<Integer>> list = new LinkedList<>();
    private int[] nums;
    private int length;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
        permute(new LinkedList<>());
        return list;
    }

    private void permute(LinkedList<Integer> curr) {
        if (curr.size() == length) {
            list.add(new ArrayList<>(curr));
            // 如果求组合，把length改一下，然后return就好
        }
        for (int i = 0; i < length; i++) {
            // 给回溯套路增加一个条件
            if (!curr.contains(nums[i])) {
                curr.add(nums[i]);
                permute(curr);
                curr.removeLast();
            }
        }
    }
}