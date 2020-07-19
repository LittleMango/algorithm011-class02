import java.util.*;

public class Solution126 {

    public static void main(String[] args) {
        Solution126 solution = new Solution126();
        solution.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) {
            return result;
        }

        // 临时字符串数组
        HashSet<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);

        // 每次可以变换的字符
        List<String> charList = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");

        // 中间队列
        Deque<Data> deque = new ArrayDeque<>();
        deque.offerLast(new Data(beginWord));

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Data> datas = new ArrayList<>();
            // 遍历一层
            for (int i = 0; i < size; i++) {
                datas.add(deque.pollFirst());
            }
            // 看看是否找到了
            for (Data data : datas) {
                if (data.list.get(data.list.size() - 1).equals(endWord)) {
                    result.add(data.list);
                }
            }
            // 如果找到了，就返回
//            if (result.size() > 0) {
//                return result;
//            }
            // 没找到，将所有元素再次拓展
            for (Data data : datas) {
                String temp = data.list.get(data.list.size() - 1);
                for (int i = 0; i < temp.length(); i++) {
                    for (String s : charList) {
                        String target = new StringBuilder(temp).replace(i, i + 1, s).toString();
                        if (!data.visitedSet.contains(target) && wordSet.contains(target)) {
                            Data newData = new Data(data);
                            newData.visitedSet.add(target);
                            newData.list.add(target);
                            deque.offerLast(newData);
                        }
                    }
                }
            }
        }

        return result;
    }

    public static class Data {
        public HashSet<String> visitedSet;
        public List<String> list;

        public Data() {
            visitedSet = new HashSet<>();
            list = new ArrayList<>();
        }

        public Data(String str) {
            this();
            visitedSet.add(str);
            list.add(str);
        }

        public Data(Data data) {
            this();
            visitedSet.addAll(data.visitedSet);
            list.addAll(data.list);
        }
    }
}
