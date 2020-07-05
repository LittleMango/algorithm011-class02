import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : nums) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (map.get(o1) - map.get(o2)));
        for (int value : map.keySet()) {
            queue.offer(value);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
