public class Solution198 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = nums[i - 2];
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
        }
        return dp[dp.length - 1];
    }
}
