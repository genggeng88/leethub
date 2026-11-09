class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) return -1;
                else if (a[0] > b[0]) return 1;
                else {
                    return Integer.compare(b[1], a[1]);
                }
            }
        });

        int cnt = 0;
        int[] remove = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // conflict => remove the one has longer ending time
            if (remove[1] > interval[0]) {
                if (remove[1] > interval[1]) {
                    remove = interval;
                }
                cnt++;
            }
            else {
                remove = interval;
            }
        }
        return cnt;
    }
}