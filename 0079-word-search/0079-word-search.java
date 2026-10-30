class Solution {
    final static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m = 0;
    int n = 0;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        if (board[0] == null || board[0].length == 0) return false;
        m = board.length;
        n = board[0].length;
        boolean[][] seen = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    seen[i][j] = true;
                    if (dfs(1, i, j, board, word, seen)) return true;
                    seen[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean dfs(int idx, int i, int j, char[][] board, String word, boolean[][] seen) {
        if (idx == word.length()) return true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (!seen[x][y] && board[x][y] == word.charAt(idx)) {
                    seen[x][y] = true;
                    if (dfs(idx+1, x, y, board, word, seen)) return true;
                    seen[x][y] = false;
                }
            }
        }
        return false;
    }
}