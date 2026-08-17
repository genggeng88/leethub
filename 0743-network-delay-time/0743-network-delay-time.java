class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int start = time[0], end = time[1], weight = time[2];
            graph.get(start - 1).add(new int[]{end, weight});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int[] delayTimes = new int[n];
        Arrays.fill(delayTimes, Integer.MAX_VALUE);
        delayTimes[k-1] = 0;
        minHeap.offer(new int[]{k, 0});

        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int start = node[0], weight = node[1];
            if (weight > delayTimes[start - 1]) continue;

            for (int[] nei : graph.get(start - 1)) {
                int news = nei[0], neww = weight + nei[1];
                if (neww < delayTimes[news - 1]) {
                    delayTimes[news - 1] = neww;
                    minHeap.offer(new int[]{news, neww});
                }
            }
        }

        int res = 0;
        for (int num : delayTimes) {
            if (num == Integer.MAX_VALUE) return -1;
            res = Math.max(res, num);
        }
        return res;
    }
}