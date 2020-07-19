public class Solution74 {

    public static void main(String[] args) {
        Solution74 solution367 = new Solution74();
        System.out.println(solution367.searchMatrix(new int[][]{{1}}, 0));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        } else if (matrix[0].length == 0) {
            return false;
        }
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        // 加个有效索引判断
        if (right < 0) {
            return false;
        }
        int col = right;
        left = 0;
        right = matrix[col].length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (matrix[col][mid] > target) {
                right = mid - 1;
            } else if (matrix[col][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
