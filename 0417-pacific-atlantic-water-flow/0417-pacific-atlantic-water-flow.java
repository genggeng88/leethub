class Solution {
    final static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(heights[a[0]][a[1]], heights[b[0]][b[1]]);
            }
        });

        checkReach(minHeap, heights, pacific, true);
        checkReach(minHeap, heights, atlantic, false);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void checkReach(PriorityQueue<int[]> minHeap, int[][] heights, boolean[][] canReach, boolean isPacific) {
        int m = heights.length, n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        if (isPacific) {
            for (int j = 0; j < n; j++) {
                minHeap.offer(new int[]{0, j});
                visited[0][j] = true;
                canReach[0][j] = true;
            }
            for (int i = 1; i < m; i++) {
                minHeap.offer(new int[]{i, 0});
                visited[i][0] = true;
                canReach[i][0] = true;
            }
        }
        else {
            for (int j = 0; j < n; j++) {
                minHeap.offer(new int[]{m-1, j});
                visited[m-1][j] = true;
                canReach[m-1][j] = true;
            }
            for (int i = 0; i < m-1; i++) {
                minHeap.offer(new int[]{i, n-1});
                visited[i][n-1] = true;
                canReach[i][n-1] = true;
            }
        }

        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] 
                && heights[x][y] >= heights[cell[0]][cell[1]]) {
                    canReach[x][y] = true;
                    minHeap.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }
}