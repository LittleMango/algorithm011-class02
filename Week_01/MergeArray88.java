import java.util.Arrays;

public class MergeArray88 {

    public static void main(String... argv) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        // 4 5 6 0 0 0
        // 1 2 3

        //
        new MergeArray88().merge1(num1, 3, num2, 3);
    }

    /**
     * 和合并链表一样的思路
     * 时间复杂度为O(m + n)，空间复杂度为O(m)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return;
        }
        int[] temp = Arrays.copyOfRange(nums1, 0, m);
        int move1 = 0;
        int move2 = 0;
        int moveTemp = 0;
        while (moveTemp < m && move2 < n) {
            if (temp[moveTemp] < nums2[move2]) {
                nums1[move1++] = temp[moveTemp++];
            } else {
                nums1[move1++] = nums2[move2++];
            }
        }
        if (moveTemp < m) {
            System.arraycopy(temp, moveTemp, nums1, move1, m - moveTemp);
        } else if (move2 < n) {
            System.arraycopy(nums2, move2, nums1, move1, n - move2);
        }
    }

    /**
     * 由于数组1有足够的空间容纳所有元素，所以可以从后面开始遍历，这样就不需要额外的数组
     * 时间复杂度O(m + n)，空间复杂度为O(1)
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int moveTarget = m + n - 1;
        int move1 = m - 1;
        int move2 = n - 1;
        for (int i = moveTarget; i >= 0 ; i--) {
            if (move1 > -1 && move2 > -1) {
                if (nums1[move1] > nums2[move2]) {
                    nums1[moveTarget--] = nums1[move1--];
                } else {
                    nums1[moveTarget--] = nums2[move2--];
                }
            }
        }
        if (move2 > -1) {
            System.arraycopy(nums2, 0, nums1, 0, move2 + 1);
        }
    }
}
