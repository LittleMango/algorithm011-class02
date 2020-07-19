public class Solution153 {

    public static void main(String[] args) {
        Solution153 solution367 = new Solution153();
        System.out.println(solution367.findMin(new int[]{4,5,6,7,0,1,2}));
    }

    // 有N种组合，主要要找出不重复的那组做if，其它做else，那么就是找出那组绝对成立的
    // 对于这道题来说，绝对成立的就是中间比右侧大，那么这个最小值就一定在中间和右侧之间
    // 对于找指定数的那道题
    // 如果左边小于中间，如果target小于两端，那么目标一定在这个区间，否则就在另一边
    // 如果中间小于右侧，如果target小于两端，那么目标一定在这个区间，否则就在另一边
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= nums[right]) {
                // 最小值在这里
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
}
