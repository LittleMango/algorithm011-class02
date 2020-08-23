public class Solution63 {

    /**
     * 分治-合并，寻找f(k)和f(k-1)的规律
     * 然后直接走到终点，递推回去就好了
     * 数学归纳法的思想
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int tem = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (obstacleGrid[i][m - 1] == 1 && tem != -1) {
                tem = -1;
            }
            obstacleGrid[i][m - 1] = tem;
        }
        tem = 1;
        for (int i = m - 1; i >= 0; --i) {
            if ((obstacleGrid[n - 1][i] == 1 || obstacleGrid[n - 1][i] == -1) && tem != -1) {
                tem = -1;
            }
            obstacleGrid[n - 1][i] = tem;
        }

        for (int i = n - 1; i >= 0; --i) {
            if (obstacleGrid[i][m - 1] == -1) {
                obstacleGrid[i][m - 1] = 0;
            }
        }
        for (int i = m - 1; i >= 0; --i) {
            if (obstacleGrid[n - 1][i] == -1) {
                obstacleGrid[n - 1][i] = 0;
            }
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = m - 2; j >= 0; --j) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i + 1][j] + obstacleGrid[i][j + 1];
                }
            }
        }
        return Math.max(obstacleGrid[0][0], 0);
    }
}
