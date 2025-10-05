class Solution {
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        if (m == 0) return List.of();
        int n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        Deque<int[]> qPac = new ArrayDeque<>();
        Deque<int[]> qAtl = new ArrayDeque<>();

        for (int c = 0; c < n; c++) add(qPac, pac, 0, c);
        for (int r = 0; r < m; r++) add(qPac, pac, r, 0);

        for (int c = 0; c < n; c++) add(qAtl, atl, m-1, c);
        for (int r = 0; r < m; r++) add(qAtl, atl, r, n-1);

        bfs(heights, qPac, pac);
        bfs(heights, qAtl, atl);

        List<List<Integer>> res = new ArrayList<>();
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    private void bfs(int[][] h, Deque<int[]> q, boolean[][] vis) {
        int m = h.length, n = h[0].length;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (!vis[nr][nc] && h[nr][nc] >= h[r][c]) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    private void add(Deque<int[]> q, boolean[][] vis, int r, int c) {
        if (!vis[r][c]) {
            vis[r][c] = true;
            q.offer(new int[]{r, c});
        }
    }
}