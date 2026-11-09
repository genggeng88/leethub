class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int cnt = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // conflict => remove the one has longer ending time
            if (interval[0] < prevEnd) {
                prevEnd = Math.min(interval[1], prevEnd);
                cnt++;
            }
            else {
                prevEnd = interval[1];
            }
        }
        return cnt;
    }
}