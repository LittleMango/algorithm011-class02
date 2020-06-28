import java.util.Arrays;

public class RotateArray189 {

    public static void main(String... argv) {
        new RotateArray189().rotate1(new int[]{-1, -100, 3, 99}, 2);
    }

    /**
     * 移动k次数组，每次将所有元素向右移动一次
     * 时间复杂度O(k * n)、空间复杂度为O(1)
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        } else {
            int offset = k % nums.length + 1;
            for (int i = 0; i < offset; i++) {
                int temp = nums[nums.length - 1];
                System.arraycopy(nums, 0, nums, 1, nums.length - 1);
                nums[0] = temp;
            }
        }
    }

    /**
     * 用两个数组保存连续的两部分数据
     * 时间复杂度O(n)，空间复杂度(n)
     */
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        } else {
            int offset = k % nums.length + 1;
            int[] target1 = Arrays.copyOfRange(nums, nums.length - offset, nums.length);
            int[] target2 = Arrays.copyOfRange(nums, 0, nums.length - offset);
            for (int i = 0; i < nums.length; i++) {
                if (i < target2.length) {
                    nums[i] = target2[i];
                } else {
                    nums[i] = target1[i - target2.length];
                }
            }
        }
    }
}
