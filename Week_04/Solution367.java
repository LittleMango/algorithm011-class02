public class Solution367 {

    public static void main(String[] args) {
        Solution367 solution367 = new Solution367();
        System.out.println(solution367.isPerfectSquare(808201));
    }
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        // 注意要用Long，否则可能最终结果越界
        long left = 1;
        // right用 1/2 * num，否则会超时
        long right = num / 2;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            long target = mid * mid;
            if (target == num) {
                return true;
            } else if (target < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
