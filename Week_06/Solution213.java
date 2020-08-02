public class Solution213 {

    public static void main(String[] args) {
        new Solution213().rob(new int[]{1});
    }
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = nums[i - 2];
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
        }
        int max = dp[dp.length - 1];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = nums[i - 1];
        }

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
        }

        return Math.max(max, dp[dp.length - 1]);
    }
}
