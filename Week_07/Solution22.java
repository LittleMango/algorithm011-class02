import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution22 {

    private LinkedList<String> list = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return list;
        }
        Deque<String> deque = new ArrayDeque<>();
        deque.offerLast("(");
        while (!deque.isEmpty()) {
            String child = deque.pollFirst();
            int leftCount = count(child, '(');
            int rightCount = count(child, ')');
            if (leftCount < n) {
                deque.offerLast(child + "(");
            }
            if (rightCount < n && rightCount < leftCount) {
                if (rightCount == n - 1 && leftCount == n) {
                    list.add(child + ")");
                } else {
                    deque.offerLast(child + ")");
                }
            }
        }
        return list;
    }

    private int count(String builder, char target) {
        int count = 0;
        char[] nums = builder.toCharArray();
        for (char c : nums) {
            if (c == target) {
                count++;
            }
        }
        return count;
    }
}
