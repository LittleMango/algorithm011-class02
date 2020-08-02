public class Solution221 {

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '1', '1', '1'},
        };
        System.out.println(new Solution221().maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        /**
         * [1,1,1]
         * [1,1,1]
         * [1,1,1]
         *
         * 求第dp[i][j]
         * 1. 如果source[i][j] == 0，那么dp[i][j] == 0
         * 2. 如果source[i][j] == 1,  那么就看看上边，左边，左上的位置的值，取最小值开根号+1 ^ 2就好了
         *
         * 结果呢? 遍历数组，找到最大值
         *
         * base case?
         * 第一行和第一列不变
         *
         * 综上那么原地dp就好了，但是原本是char[][]，为了防止溢出还是要新建dp，注意char和int的转换
         */
        int n = matrix.length; // 行
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length; // 列
        int[][] dp = new int[n][m];

        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0] - '0';
            if (dp[i][0] == 1 && max != 1) {
                max = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i] - '0';
            if (dp[0][i] == 1 && max != 1) {
                max = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != '0') {
                    int min = (int) (Math.sqrt(Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])) + 1);
                    dp[i][j] = min * min;
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }
}
