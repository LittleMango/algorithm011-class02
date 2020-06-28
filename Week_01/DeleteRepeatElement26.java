public class DeleteRepeatElement26 {

    /**
     * 有序说明如果出现重复元素，则重复元素一定是连续的，所以通过指向连续位置的快慢指针，可以比较连续位置上的元素是否是相等
     * 然后通过对几个有代表性的测试用例[]、[0]、[0, 0]、[0, 0, 0]、[0, 1, 1, 1]、[0,0,1,1,1,2,2,3,3,4]
     * 进行按步骤图解，就可以得出具体的算法步骤了
     * 时间复杂度O(n)、空间复杂度O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 ) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        } else {
            int count = 1;
            int index = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] != nums[i + 1]) {
                    count++;
                    nums[index++] = nums[i + 1];
                }
            }
            return count;
        }
    }
}
