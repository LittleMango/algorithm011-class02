import java.util.Arrays;

public class Solution300 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 暴力是枚举所有子序列，然后遍历每组子序列看看是不是升序，时间复杂度为O(n^3)
        // 题目要求O(n^2)，那么应该是用一个一维数组做备忘录
        // dp[n] 记录当前最大的升序子序列的长度
        // dp[n]的递推公式是遍历[0, n-1]，找到一个比它小并且长度最长的的数，然后+1
        // 如果找不到则本身为1
        // base case: dp[i] = 1;
        // result: 遍历dp，找出最大值
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; ++i) {
            int max = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        int max = -1;
        for (int d : dp) {
            max = Math.max(max, d);
        }
        return max;
    }
}
