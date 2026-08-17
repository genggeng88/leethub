class Solution {
    private final static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        if (grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(int i, int j, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] dir : dirs) {
                int newi = dir[0] + node[0], newj = dir[1] + node[1];
                if (inbound(newi, newj, grid.length, grid[0].length) && grid[newi][newj] == '1') {
                    queue.offer(new int[]{newi, newj});
                    grid[newi][newj] = '0';
                }
            }
        }
    }
    
    private boolean inbound(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}