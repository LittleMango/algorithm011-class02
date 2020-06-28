
public class AddOne66 {

    public static void main(String... argv) {
        new AddOne66().plusOne(new int[]{1, 2, 9});
    }

    /**
     * 需要考虑进位问题，
     * 时间复杂度O(n)，再不是全部元素为9的情况下，空间复杂度为O(1)，否则为O(n)
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int carry = 1;
        for (int i = digits.length - 1; i >= 0 ; i--) {
            if (carry == 0) {
                // 结束
                break;
            }
            int num = digits[i] + carry;
            if (num / 10 > 0) {
                // 进位
                carry = 1;
                digits[i] = 0;
            } else {
                // 不要进位
                carry = 0;
                digits[i] = num;
            }
        }

        if (carry == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
    }
}
