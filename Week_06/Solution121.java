
public class Solution121 {

    public static void main(String[] args) {
        new Solution121().maxProfit(new int[]{7,1,5,3,6,4});
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        int max = prices[prices.length - 1];
        dp[dp.length - 1] = max;
        for (int i = dp.length - 2; i >= 0; --i) {
            dp[i] = Math.max(prices[i], max);
            max = Math.max(max, dp[i]);
        }

        max = 0;
        for (int i = 0; i < prices.length; ++i) {
            max = Math.max(max, dp[i] - prices[i]);
        }
        return max;
    }
}
