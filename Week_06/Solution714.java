
public class Solution714 {

    public static void main(String[] args) {
        System.out.println(new Solution714().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        // base case
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][1] + prices[i] - fee, dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
