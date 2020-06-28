import java.util.HashMap;

public class SumOfTwoNum1 {

    public static void main(String... argv) {
        int[] result = new SumOfTwoNum1().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result);
    }

    /**
     * 利用hashMap，时间复杂度O(n)、空间复杂度O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int num = target - current;
            if (map.containsKey(num)) {
                return new int[] {map.get(num), i};
            } else {
                map.put(current, i);
            }
        }
        return null;
    }
}
