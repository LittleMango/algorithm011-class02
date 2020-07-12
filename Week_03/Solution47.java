import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution47 {

    public static void main(String[] args) {
        Solution47 solution = new Solution47();
        List<List<Integer>> list = solution.permuteUnique(new int[]{1, 1, 3,});
        System.out.println(list.size());
    }

    /**
     * 以 [1, 1, 3]为例子
     * 先画树
     *                *
     *        1       1       3
     *      1 1 3   1 1 3   1 1 3
     *
     *  可以看到第一个分支和第二个分支重复了，剪支吧
     *  用一个map存储每一个数字出现的次数，然后只要次数不超过，就可以纳入结果
     *
     */

    private List<List<Integer>> mList = new LinkedList<>();
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int[] nums;
    private int targetLength;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.targetLength = nums.length;
        // 记录每个元素出现的次数
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 去重之后的数组
        this.nums = deleteRepeat(nums);
        // 回溯
        permute(new LinkedList<>());
        return mList;
    }

    private int[] deleteRepeat(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        int[] newNums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newNums[i] = list.get(i);
        }
        return newNums;
    }

    private void permute(LinkedList<Integer> curr) {
        if (curr.size() == targetLength) {
            mList.add(new ArrayList<>(curr));
            // 如果求组合，把length改一下，然后return就好
        }
        for (int num : nums) {
            // 给回溯套路增加一个条件
            if (containCount(curr, num) < map.get(num)) {
                curr.add(num);
                permute(curr);
                curr.removeLast();
            }
        }
    }

    private int containCount(LinkedList<Integer> curr, int num) {
        int count = 0;
        for (Integer integer : curr) {
            if (integer == num) {
                count++;
            }
        }
        return count;
    }
}