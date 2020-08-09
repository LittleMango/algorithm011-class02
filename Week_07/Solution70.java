public class Solution70 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int p = 1;
        int q = 2;
        int sum = 2;
        for(int i = 3; i <= n; ++i) {
            sum = p + q;
            p = q;
            q = sum;
        }
        return sum;
    }
}
