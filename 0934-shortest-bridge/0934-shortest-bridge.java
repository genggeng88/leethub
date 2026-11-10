class Solution {
    final static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> buffer = new ArrayDeque<>();
        boolean found = false;

        for (int i = 0; i < m && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(queue, buffer, visited, grid);
                    found = true;
                }
            }
        }

        int bridge = 0;
        while (!buffer.isEmpty()) {
            int size = buffer.size();
            for (int i = 0; i < size; i++) {
                int[] cell = buffer.poll();
                for (int[] dir : dirs) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            return bridge;
                        }
                        visited[x][y] = true;
                        buffer.offer(new int[]{x, y});
                    }
                }
            }
            bridge++;
        }
        return bridge;
    }

    private void bfs(Queue<int[]> queue, Queue<int[]> buffer, boolean[][] visited, int[][] grid) {
        int m = visited.length, n = visited[0].length;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            buffer.offer(cell);
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    if (grid[x][y] == 1) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }
    }
}