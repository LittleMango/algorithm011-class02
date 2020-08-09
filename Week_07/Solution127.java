import java.util.*;

public class Solution127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Deque<String> deque = new ArrayDeque<>();

        // BFS set 保存，查询的时间复杂度为1
        HashSet<String> visits = new HashSet<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        deque.offerLast(beginWord);
        visits.add(beginWord);
        List<String> charList = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");

        int times = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String child = deque.pollFirst();
                if (child.equals(endWord)) {
                    return times;
                }
                for (int j = 0; j < child.length(); j++) {
                    for (String aChar : charList) {
                        String target = new StringBuilder(child).replace(j, j + 1, aChar).toString();
                        if (!visits.contains(target) && wordSet.contains(target)) {
                            visits.add(target);
                            deque.offerLast(target);
                        }
                    }
                }
            }
            times++;
        }
        return 0;
    }
}
