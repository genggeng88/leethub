class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int cnt = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (minHeap.isEmpty()) minHeap.offer(interval[1]);
            else if (minHeap.peek() > interval[0]) {
                if (minHeap.peek() > interval[1]) {
                    minHeap.poll();
                    minHeap.offer(interval[1]);
                }
                cnt++;
            }
            else {
                minHeap.poll();
                minHeap.offer(interval[1]);
            }
        }
        return cnt;
    }
}


// sort by start, 
// for each interval
//     // conflict
//     if peek()[1] > interval[0] {
//         if peek()[1] > interval[1] {
//             poll();
//             offer(interval);
//         }
//         else {
//             do nothing // skip interval
//         }
//         cnt++;
//     }
//     else {
//         poll();
//         offer(interval);
//     }