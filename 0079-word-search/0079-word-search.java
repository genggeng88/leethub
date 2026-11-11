class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, board, 0, word, visited)) {
                    return true;
                }
            }
        } 
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, int idx, String word, boolean[][] visited) {
        if (idx >= word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (visited[i][j] || board[i][j] != word.charAt(idx)) return false;
        
        visited[i][j] = true;
        if (dfs(i+1, j, board, idx+1, word, visited)) return true;
        if (dfs(i-1, j, board, idx+1, word, visited)) return true;
        if (dfs(i, j+1, board, idx+1, word, visited)) return true;
        if (dfs(i, j-1, board, idx+1, word, visited)) return true;

        return false;
    }
}