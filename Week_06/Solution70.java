public class Solution70 {

    public int climbStairs(int n) {
        int q = 0, p = 0, sum = 1;
        for (int i = 1; i <= n; i++) {
            q = p;
            p = sum;
            sum = p + q;
        }
        return sum;
    }
}
