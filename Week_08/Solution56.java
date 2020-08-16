import java.util.Arrays;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        // 排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int move = 0;
        for (int i = 1; i < intervals.length; i++) {
            int end = intervals[move][1];
            if (intervals[i][0] <= end) {
                if (intervals[i][1] > end) {
                    intervals[move][1] = intervals[i][1];
                }
            } else {
                move++;
                intervals[move][0] = intervals[i][0];
                intervals[move][1] = intervals[i][1];
            }
        }
        int[][] result = new int[move+1][2];
        for (int i = 0; i <= move; i++) {
            result[i] = intervals[i];
        }
        return result;
    }
}
