public class Solution152 {

    public int maxProduct(int[] nums) {
        // f(i) = Math.max(f(i), f(i) * imax)
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);
            max = Math.max(max, imax);
        }
        return max;
    }
}
