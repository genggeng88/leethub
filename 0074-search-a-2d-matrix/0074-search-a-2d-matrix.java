class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = rows * cols - 1;
        while (i <= j) {
            int m = i + (j - i)/2;
            int r = m / cols, c = m % cols;
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] < target) i = m + 1;
            else j = m - 1;
        }
        return false;
    }
}