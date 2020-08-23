public class Solution5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        //如果char[i] == char[j] 要看[i+1, j-1]是不是回文，分2种情况
        //如果char[i] != char[j] 那么[i, j]肯定不是回文
        // 所以这里用dp，递推方程就是上面的4个分支，不过需要注意的时候，这里需要按列遍历，因为j-1;
        // base case是 对角线都是回文
        // result则是每次在[i,j]是回文的时候更新区间角标
        // dp[i][j]表示闭合区间[i,j]是不是回文
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; ++i) {
            dp[i][i] = true;
        }
        int lpStart = 0;
        int lpEnd = 0;
        for (int j = 0; j < length; ++j) {
            for (int i = 0; i < j; ++i) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (s.charAt(i + 1) == s.charAt(j - 1)) {
                        dp[i][j] = true;
                        if (j - i > lpEnd - lpStart) {
                            lpStart = i;
                            lpEnd = j;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(lpStart, lpEnd + 1);
    }
}
