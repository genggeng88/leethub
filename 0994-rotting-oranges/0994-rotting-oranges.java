class Solution {
    final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        if (grid[0] == null || grid[0].length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int freshCnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) freshCnt++;
            }
        }
        if (freshCnt == 0) return 0;
        int time = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < m && nx >= 0 && ny < n && ny >= 0) {
                        if (grid[nx][ny] == 1) {
                            freshCnt--;
                            grid[nx][ny] = 2;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            time++;
        }
        return freshCnt == 0 ? time : -1;
    }
}