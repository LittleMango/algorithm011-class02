import java.util.HashMap;

public class Solution1 {

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
