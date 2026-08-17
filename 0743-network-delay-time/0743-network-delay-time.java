class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int res = 0;
        List<List<int[]>> adjs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjs.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int from = time[0], to = time[1], weight = time[2];
            adjs.get(from - 1).add(new int[]{to, weight});
        }

        int[] delayTimes = new int[n];
        Arrays.fill(delayTimes, Integer.MAX_VALUE);
        delayTimes[k-1] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]); 
            }
        });

        minHeap.offer(new int[]{k, 0});

        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int dist = node[1];
            if (dist > delayTimes[node[0] - 1]) continue;

            delayTimes[node[0] - 1] = node[1];
            List<int[]> neighbors = adjs.get(node[0] - 1);
            for (int[] neighbor : neighbors) {
                int newDist = dist + neighbor[1];
                if (newDist < delayTimes[neighbor[0] - 1]) {
                    delayTimes[neighbor[0] - 1] = newDist;
                    minHeap.offer(new int[]{neighbor[0], newDist});
                }
            }
        }

        for (int delayTime : delayTimes) {
            if (delayTime == Integer.MAX_VALUE) return -1;
            res = Math.max(res, delayTime);
        }
        return res;
    }
}