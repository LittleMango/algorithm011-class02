
public class Solution122 {

    public static void main(String[] args) {
        new Solution122().maxProfit(new int[]{7,1,5,3,6,4});
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        int i =0; // 买入时间
        int j = 1; // 卖出时间
        while (j < prices.length) {
            int pre = prices[i];
            int curr = prices[j];
            // 大于前一天就卖掉
            /* 这个是简化的，不好理解
            if (curr > pre) {
                max += curr - pre;
            }
            i = j;
            j++;
             */
            // 下面写个逻辑清晰的
            if (curr > pre) {
                // 比前面一个最小值小，则卖出
                max += curr - pre;
                // 然后再尝试买入当天的
                i = j;
                j++;
            } else {
                // 最佳买入时机要变
                i = j;
                j++;
            }
        }
        return max;
    }
}
