class Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        if (grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int time = -1;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] cell = queue.poll();
                for (int[] dir : dirs) {
                    int newi = cell[0] + dir[0];
                    int newj = cell[1] + dir[1];
                    if (inbound(newi, newj, m, n) && grid[newi][newj] == 1) {
                        grid[newi][newj] = 2;
                        queue.offer(new int[]{newi, newj});
                    }
                }
            }
            time++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time == -1 ? 0 : time;
    }

    private boolean inbound(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j <n;
    }
}