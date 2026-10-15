class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        if (intervals[0] == null || intervals[0].length == 0) return new int[][]{};
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> buffer = new LinkedList<>();
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            // overlap
            if (next[0] <= curr[1]) {
                curr[0] = Math.min(curr[0], next[0]);
                curr[1] = Math.max(curr[1], next[1]);
            }
            // no overlap, curr is non-overlapping interval i need
            else {
                buffer.add(curr);
                curr = next;
            }
        }
        buffer.add(curr);
        int[][] res = new int[buffer.size()][2];
        for (int i = 0; i < buffer.size(); i++) {
            res[i] = buffer.get(i);
        }
        return res;
    }
}