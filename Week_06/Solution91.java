
public class Solution91 {

    public static void main(String[] args) {
        System.out.println(new Solution91().numDecodings("101"));
    }

    public int numDecodings(String s) {
        /**
         * 12301
         * 1230-1
         * 123-01  不能分
         *
         * 1230
         * 123-0 X
         * 12-30 X
         *
         * 1220
         * 12-20
         *
         * 所以递推公式就出来了
         * dp[i] = dp[i-1] + (ch[i-2] > 0 && ch[i-2] < 3 ? ch[i-2] - '0' * 10 + ch[i-1] - '0') < 27 ? 1 : 0
         * 如果ch[i] == 0 && (ch[i-1] == 0 || ch[i-1] > 2) return 0 else dp[i] = dp[i-2]
         *
         * 结果 f(length - 1)
         *
         * base case
         * dp[0] = 1 哨兵
         * dp[1] = 1 // 字符串第一个数
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
