class Solution {
    private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] minEfforts = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(minEfforts[i], Integer.MAX_VALUE);
        }
        minEfforts[0][0] = 0;

        // int[]: i, j, effort
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int [] b) {
                return Integer.compare(a[2], b[2]);
            }
        });

        minHeap.offer(new int[]{0, 0, 0});
        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int i = node[0], j = node[1], effort = node[2];
            if (node[2] > minEfforts[i][j]) continue;

            for (int[] dir : dirs) {
                int newi = i + dir[0], newj = j + dir[1];
                if (!inbound(newi, newj, m, n)) continue;
                
                int newEffort = Math.max(Math.abs(heights[newi][newj] - heights[i][j]), effort);
                if (newEffort < minEfforts[newi][newj]) {
                    minEfforts[newi][newj] = newEffort;
                    minHeap.offer(new int[]{newi, newj, newEffort});
                }
            }
        }
        return minEfforts[m-1][n-1];
    }

    private boolean inbound(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}