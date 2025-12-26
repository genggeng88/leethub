class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int prevEnd = intervals[0][1];
        int cnt = 0;
        for (int i=1; i<intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] < prevEnd) {
                cnt++;
                prevEnd = Math.min(prevEnd, curr[1]);
            } else {
                prevEnd = curr[1];
            }
        }
        return cnt;
    }
}