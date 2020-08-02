
public class Solution123 {

    public static void main(String[] args) {
        System.out.println(new Solution123().maxProfit(new int[]{1,2,3,4,5}));
    }

    private int[] dp;
    public int maxProfit(int[] prices) {
        // 划分区间，求两个区间相加的最大值
        // [0, i]、(i,length-1]
        int max = 0;
        dp = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; --i) {
            dp[i] = Math.max(prices[i], max);
            max = dp[i];
        }
        max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, divide(0, i, prices) + divide(i, prices.length - 1, prices));
        }
        return max;
    }

    private int divide(int start, int end, int[] source) {
        int max = 0;
        if (start == 0) {
            for (int i = end; i >= start; --i) {
                dp[i] = Math.max(max, source[i]);
                max = dp[i];
            }
            max = 0;
        } else if (start + 1 <= end){
            dp[start] = Math.max(dp[start + 1], dp[start]);
        }
        for (int i = start; i < end; i++) {
            max = Math.max(max, dp[i] - source[i]);
        }
        return max;
    }
}
