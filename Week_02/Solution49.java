import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        // hashMap  "排序key": List<String>
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] sChar = s.toCharArray();
            Arrays.sort(sChar);
            String re = String.valueOf(sChar);
            if (map.containsKey(re)) {
                map.get(re).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(re, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
