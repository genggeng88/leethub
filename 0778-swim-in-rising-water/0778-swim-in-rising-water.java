class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] best = new int[n][n];
        for (int[] row : best) Arrays.fill(row, Integer.MAX_VALUE);

        // cost, r, c
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int start = grid[0][0];
        best[0][0] = start;
        pq.offer(new int[]{start, 0, 0});

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], r = cur[1], c = cur[2];

            if (r == n - 1 && c == n - 1) return cost; // earliest reach with minimal max height

            if (cost > best[r][c]) continue; // stale

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                int ncost = Math.max(cost, grid[nr][nc]);
                if (ncost < best[nr][nc]) {
                    best[nr][nc] = ncost;
                    pq.offer(new int[]{ncost, nr, nc});
                }
            }
        }
        return -1;
    }
}