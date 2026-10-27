class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tmp = new ArrayList<>();
        int n = intervals.length;

        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0]) {
                tmp.add(newInterval);
                newInterval = interval;
            }
            else if (interval[1] < newInterval[0]) {
                tmp.add(interval);
            }
            else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        tmp.add(newInterval);
        int[][] res = new int[tmp.size()][2];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
}