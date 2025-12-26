class Solution {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length < 1 || intervals[0] == null || intervals[0].length == 0) {
            return new int[]{-1};
        }
        int[][] copyIntervals = Arrays.copyOf(intervals, intervals.length);
        Map<int[], Integer> map = new HashMap<>();
        for (int i=0; i<intervals.length; i++) {
            map.put(intervals[i], i);
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int[] result = new int[intervals.length];
        for (int i=0; i<intervals.length; i++) {
            int curIdx = findSmallestStartLarger(intervals, copyIntervals[i][1]);
            result[i] = curIdx == -1 ? -1 : map.get(intervals[curIdx]);
        }
        return result;
    }

    public int findSmallestStartLarger(int[][] intervals, int target) {
        int i = 0, j = intervals.length;
        while (i < j) {
            int mid = i + (j-i)/2;
            if (intervals[mid][0] < target) {
                i = mid+1;
            } else {
                j = mid;
            }
        }
        return (i < intervals.length && intervals[i][0] >= target) ? i : -1;
    }
}