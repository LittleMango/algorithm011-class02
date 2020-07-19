import java.util.*;

public class Solution55 {

    public static void main(String[] args) {
        Solution55 solution22 = new Solution55();
        boolean result = solution22.canJump(new int[]{3,2,1,0,4});
        System.out.println(result);
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean[] result = new boolean[nums.length];
        Arrays.fill(result, false);
        result[0] = true;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean isAbove = result[i];
            if (!isAbove) {
                return false;
            } else {
                int num = nums[i];
                int nextStep = num + i;
                if (nextStep >= maxIndex) {
                    for (int j = maxIndex; j <= nextStep && j < nums.length; j++) {
                        result[j] = true;
                        if (result[nums.length - 1]) {
                            return true;
                        }
                    }
                    maxIndex = nextStep;
                }
            }
        }
        return false;
    }

    /**
     * 暴力求解
     */
    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean[] result = new boolean[nums.length];
        Arrays.fill(result, false);
        result[0] = true;
        for (int i = 0; i < nums.length; i++) {
            boolean isAbove = result[i];
            if (!isAbove) {
                return false;
            } else {
                int num = nums[i];
                for (int j = i + 1; j < i + 1 + num && j < nums.length; j++) {
                    result[j] = true;
                }
                if (result[nums.length - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
