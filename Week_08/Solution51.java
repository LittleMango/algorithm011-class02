import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution51 {
    private LinkedList<List<String>> list = new LinkedList<>();

    private int max;

    public List<List<String>> solveNQueens(int n) {
        max = n;
        // -1 表示不行, 0表示可以， 1表示占位
        int[][] nums = new int[n][n];
        drill(0, nums);
        return list;
    }

    private void drill(int row, int[][] nums) {
        if (row == max) {
            ArrayList<String> answer = new ArrayList<>();
            for (int i = 0; i < max; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < max; j++) {
                    if (nums[i][j] == 1) {
                        builder.append("Q");
                    } else {
                        builder.append(".");
                    }
                }
                answer.add(builder.toString());
            }
            list.add(answer);
            return;
        }
        for (int i = 0; i < max; i++) {
            if (canOccuy(nums, row, i)) {
                nums[row][i] = 1;
                drill(row + 1, nums);
                nums[row][i] = 0;
            }
        }
    }

    private boolean canOccuy(int[][] nums, int row, int col) {
        // 这一列有没有皇后
        for (int i = 0; i < max; i++) {
            if (nums[i][col] == 1) {
                return false;
            }
        }
        // 这一行有没有皇后
        for (int i = 0; i < max; i++) {
            if (nums[row][i] == 1) {
                return false;
            }
        }

        // \方向有没有皇后
        int move = 1;
        while (row + move < max && col + move < max) {
            if (nums[row + move][col + move] == 1) {
                return false;
            }
            move++;
        }
        move = -1;
        while (row + move > -1 && col + move > -1) {
            if (nums[row + move][col + move] == 1) {
                return false;
            }
            move--;
        }

        // /方向有没有皇后
        move = 1;
        while (row + move < max && col - move > -1) {
            if (nums[row + move][col - move] == 1) {
                return false;
            }
            move++;
        }

        move = -1;
        while (row + move > -1 && col - move < max) {
            if (nums[row + move][col - move] == 1) {
                return false;
            }
            move--;
        }
        return true;
    }
}
