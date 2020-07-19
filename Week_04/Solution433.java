import java.util.*;

public class Solution433 {

    public static void main(String[] args) {
        Solution433 solution = new Solution433();
        solution.minMutation("AACCGGTT", "AAACGGTA", new String[] {"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"});
    }
    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0 || start == null || end == null) {
            return -1;
        }

        Deque<String> deque = new ArrayDeque<>();
        deque.offerLast(start);
        List<String> bankList = Arrays.asList(bank);
        char[] dest = end.toCharArray();

        // 注意要记录已经访问过的字符串
        List<String> visited = new ArrayList<>();

        String[] chars = new String[]{"A", "C", "G", "T"};

        // 记录层数
        int times = 0;
        while (!deque.isEmpty()) {
            // 每次遍历一层
            int n = deque.size();
            for (int j = 0; j < n; j++) {
                String childStr = deque.pollFirst();
                if (childStr.equals(end)) {
                    return times;
                }
                // 对该层每一个字符串变换(8次)
                char[] source = childStr.toCharArray();
                for (int i = 0; i < dest.length; i++) {
                    // 每个字符变换有四种可能
                    for (String aChar : chars) {
                        String changeStr = new StringBuilder(childStr).replace(i, i + 1, aChar).toString();
                        if (bankList.contains(changeStr) && !visited.contains(changeStr)) {
                            deque.offerLast(changeStr);
                            visited.add(changeStr);
                        }
                    }
                }
            }

            times++;
        }
        return -1;
    }
}
