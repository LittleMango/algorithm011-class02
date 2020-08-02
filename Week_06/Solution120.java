import java.util.List;

public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for (int j = 1; j < triangle.get(i).size()-1; ++j) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
            }
            dp[i][triangle.get(i).size()-1] = dp[i-1][i-1] + triangle.get(i).get(triangle.get(i).size()-1);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            if (dp[n-1][i] < min) {
                min = dp[n-1][i];
            }
        }

        return min;
    }
}
