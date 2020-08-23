public class Solution8 {

    public int myAtoi(String str) {
        // 注意大数，long也是放不下的
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int start = 0;
        char[] strs = str.toCharArray();
        if (!isValideStart(strs[0])) {
            return 0;
        }
        int isNeg = 1;
        if (isNeg(strs[0])) {
            isNeg = -1;
            start = 1;
        }

        if (isPosi(strs[0])) {
            start = 1;
        }

        StringBuilder builder = new StringBuilder();
        int posiStart = -1;
        for (int i = start; i < strs.length; i++) {
            char c = strs[i];
            if (isNum(c)) {
                if (posiStart < 0 && c != '0') {
                    posiStart = builder.length();
                }
                builder.append(c);
            } else {
                break;
            }
        }
        String temp = builder.toString();
        if (posiStart > -1) {
            temp = temp.substring(posiStart, temp.length());
        }

        String result;
        if (temp.length() == 0) {
            return 0;
        } else if (temp.length() > 12) {
            result = temp.substring(0, 12);
        } else {
            result = temp.toString();
        }
        long resultLong = Long.valueOf(result) * isNeg;
        if (resultLong > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (resultLong < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)resultLong;
        }
    }

    private boolean isNum(char s) {
        return "1,2,3,4,5,6,7,8,9,0".contains(String.valueOf(s));
    }

    private boolean isNeg(char s) {
        return "-".equals(String.valueOf(s));
    }

    private boolean isPosi(char s) {
        return "+".equals(String.valueOf(s));
    }

    private boolean isValideStart(char s) {
        return isNum(s) || isNeg(s) || isPosi(s);
    }
}
