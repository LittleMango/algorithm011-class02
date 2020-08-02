import java.util.Arrays;

public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        if (dp[dp.length - 1] == amount + 1) {
            return -1;
        } else {
            return dp[dp.length - 1];
        }
    }
}
