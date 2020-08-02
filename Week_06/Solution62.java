import java.util.Arrays;

public class Solution62 {

    public static void main(String[] args) {
        System.out.println(new Solution62().uniquePaths(3, 2));
    }

    /**
     * 分治-合并，寻找f(k)和f(k-1)的规律
     * 然后直接走到终点，递推回去就好了
     * 数学归纳法的思想
     */
    public int uniquePaths(int m, int n) {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i][m - 1] = 1;
        }
        for (int i = 0; i < m; i++) {
            map[n - 1][i] = 1;
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = m - 2; j >= 0; --j) {
                map[i][j] = map[i][j + 1] + map[i + 1][j];
            }
        }
        return map[0][0];
    }
}
