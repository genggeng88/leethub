class Solution {
    final static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m = 0;
    int n = 0;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        if (grid[0] == null || grid[0].length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int cnt = 0;
        
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(new int[]{i, j});
                    grid[i][j]= '0';
                    bfs(grid, queue);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(char[][] grid, Deque<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (grid[nx][ny] == '1') {
                        grid[nx][ny] = '0';
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}