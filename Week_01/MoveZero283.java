import java.util.Arrays;

public class MoveZero283 {

    public static void main(String... argv) {
        //[0, 1, 0, 3, 12]
        //[1, 0, 0, 3, 12]
        //[1, 3, 0, 0, 12]
        new MoveZero283().moveZeroes(new int[] {0, 1, 0, 3, 12});
    }

    /**
     * 双指针，注意边界数组[1]
     * 时间复杂度O(n)，空间复杂度O(1)
     *
     * 使用三遍循环，第一遍记录0的个数，第二遍把非零前移，第三遍将最后几个数置为0也行
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int move2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[move2++] = nums[i];
                if (i != move2 -1) {
                    nums[i] = 0;
                }
            }
        }
    }
}
