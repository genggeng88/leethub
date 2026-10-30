class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] cand = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (cand[1] < intervals[i][0]) {
                res.add(cand);
                cand = intervals[i];
            }
            else {
                int l = Math.min(cand[0], intervals[i][0]);
                int r = Math.max(cand[1], intervals[i][1]);
                cand = new int[]{l, r};
            }
        }
        res.add(cand);

        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}