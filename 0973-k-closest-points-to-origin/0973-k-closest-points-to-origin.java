class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int [] b) {
                long d1 = ((long) a[0]) * a[0] + ((long) a[1]) * a[1];
                long d2 = ((long) b[0]) * b[0] + ((long) b[1]) * b[1];
                return Long.compare(d2, d1);
            }
        });

        for (int[] point : points) {
            if (maxHeap.size() < k) {
                maxHeap.offer(point);
            }
            else {
                long d = ((long) point[0]) * point[0] + ((long) point[1]) * point[1];
                int[] peek = maxHeap.peek();
                long tmp = ((long) peek[0]) * peek[0] + ((long) peek[1]) * peek[1];
                if (d < tmp) {
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            }
        }

        int[][] res = new int[maxHeap.size()][2];
        int i = 0;
        while(!maxHeap.isEmpty()) {
            res[i++] = maxHeap.poll();
        }
        return res;
    }
}