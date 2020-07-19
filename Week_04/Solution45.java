import java.util.Arrays;

public class Solution45 {

    public static void main(String[] args) {
        Solution45 solution22 = new Solution45();
        int result = solution22.jump(new int[]{2,3,1,1,4});
        System.out.println(result);
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 记录到达第i个需要最少几步
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num + i > maxIndex) {
                maxIndex = num + i;
                for (int j = i + 1; j <= i + num && j < nums.length; j++) {
                    if (dp[j] > 1 + dp[i]) {
                        dp[j] = 1 + dp[i];
                    }
                }
            }
        }
        return dp[nums.length - 1];
    }
}
