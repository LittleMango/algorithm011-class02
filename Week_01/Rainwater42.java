import java.util.HashMap;
import java.util.Map;

public class Rainwater42 {

    public static void main(String... argv) {
        Rainwater42 rainwater42 = new Rainwater42();
        int result = rainwater42.trap2(new int[] {0,1,0,2,1,0,1,3,2,1,2,1,5});
        System.out.println(result);
    }

    /**
     * 按行计算是OK的，通过314/315个用例，最后一个超时了
     * 时间复杂度是O(n * maxValue)，空间复杂度为O(1)
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = getMaxHeight(height);
        int sum = 0;
        for (int i = 1; i <= max; i++) {
            int left = -1;
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= i) {
                    if (left >= 0) {
                        sum += (j - left - 1);
                    }
                    left = j;
                }
            }
        }
        return sum;
    }

    /**
     * 遍历每一列，如果发现左侧和右侧都有比它高的列，则说明这列可以积水，容量为min(left, right) - current
     * 时间复杂度为O(n * n)， 空间复杂度为O(1)
     */
    public int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int current = height[i];
            int left = findLeftMaxHeight(height, i);
            int right = findRightMaxHeight(height, i);
            if (current < left && current < right) {
                sum += Math.min(left, right) - current;
            }
        }
        return sum;
    }

    /**
     * 基于trap1，我们发现内循环每次都会重复计算左右两侧的最大值，这里可以用备忘录的方式来减少重复运算,
     * 并且将内循环直接提取成单独的一层循环，通过保存一个常量max，来达到目的，性能和动态规划接近。
     * 动态规划暂时不是记得很清楚，先不写
     * 时间复杂度为O(n)，空间复杂度为O(n)，典型的空间换时间
     */
    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int sum = 0;
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        int max = 0;
        // 存所有列左侧的最高值
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] > max) {
                max = height[i];
            }
            leftMap.put(i + 1, max);
        }

        // 存所有列右侧的最高值
        max = 0;
        for (int i = height.length - 1; i > 0; i--) {
            if (height[i] > max) {
                max = height[i];
            }
            rightMap.put(i - 1, max);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int current = height[i];
            int left = leftMap.get(i);
            int right = rightMap.get(i);
            if (current < left && current < right) {
                sum += Math.min(left, right) - current;
            }
        }
        return sum;
    }

    private int findLeftMaxHeight(int[] height, int index) {
        int max = 0;
        for (int i = 0; i < index; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

    private int findRightMaxHeight(int[] height, int index) {
        int max = 0;
        for (int i = index + 1; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

    private int getMaxHeight(int[] height) {
        int max = 0;
        for (int num : height) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
