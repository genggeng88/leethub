class Solution {
    final static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        if (m == 1 && n == 1) return 0;
        
        int[][] efforts = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        });
        minHeap.offer(new int[]{0, 0, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currEffort = curr[2];

            if (currEffort > efforts[curr[0]][curr[1]]) continue;

            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;

                int nextEffort = Math.max(currEffort, Math.abs(heights[x][y] - heights[curr[0]][curr[1]]));
                if (nextEffort < efforts[x][y]) {
                    minHeap.offer(new int[]{x, y, nextEffort});
                    efforts[x][y] = nextEffort;
                }
            }
        }

        return efforts[m-1][n-1];
    }
}

// node: 4 dirs, newEffort = nextH - currH
//                 if newEffort < prevEffort newEffort = prevEffort,  
//                 else  newEffort        // double check ==
//                 if newEffort < efforts[i][j] => put into minHeap

// minHeap<int[]> int[] : [x, y, h]
// int[][] efforts: minEfforts to node (i, j)