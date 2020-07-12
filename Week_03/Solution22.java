import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution22 {

    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        List<String> list = solution.generateParenthesis(3);
        System.out.println(list.size());
    }

    private LinkedList<String> list = new LinkedList<>();
    private int length;

    public List<String> generateParenthesis(int n) {
        length = 2 * n;
        generateParenthesis(new StringBuilder());
        return list;
    }

    private void generateParenthesis(StringBuilder builder) {
        if (builder.length() == length) {
            list.add(builder.toString());
            return;
        }
        int leftCount = count(builder, '(');
        int rightCount = count(builder, ')');
        if (leftCount < length / 2) {
            builder.append('(');
            generateParenthesis(builder);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (rightCount < length / 2 && rightCount < leftCount) {
            builder.append(')');
            generateParenthesis(builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private int count(StringBuilder builder, char target) {
        int count = 0;
        char[] nums = builder.toString().toCharArray();
        for (char c : nums) {
            if (c == target) {
                count++;
            }
        }
        return count;
    }
}