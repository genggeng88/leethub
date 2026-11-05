class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] cells = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int cellIdx = (i / 3) * 3 + j / 3;
                    if (rows[i][num] == -1 || cols[j][num] == -1 || cells[cellIdx][num] == -1) return false;
                    else {
                        rows[i][num] = -1;
                        cols[j][num] = -1;
                        cells[cellIdx][num] = -1;
                    }
                }
                
            }
        }
        return true;
    }
}