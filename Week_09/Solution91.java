public class Solution91 {

    public int numDecodings(String s) {
        /**
         * dp[n] 表示又几种解码
         * dp[i] = dp[i - 1] if dp[i] != '0'
         * dp[i] += dp[i - 1] if  0< [i-1 ~ 1] < 27
         */
        int[] dp = new int[s.length() + 1];
        char[] ch = s.toCharArray();
        if (ch[0] == '0') {
            return 0;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (ch[i-1] == '0') {
                if (ch[i-2] == '1' || ch[i-2] == '2') {
                    dp[i] = dp[i-2];
                } else {
                    return 0;
                }
            } else {
                dp[i] = dp[i-1];
                if (ch[i-2] != '0' && ((ch[i-2] - '0') * 10 + (ch[i-1] - '0')) < 27) {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
