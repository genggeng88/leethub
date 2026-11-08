class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> tmp = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] cand = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            
            if (cand[1] < interval[0]) {       // no overlapping
                tmp.add(cand);
                cand = interval;
            }
            else {    // overlapping => merge, update cand
                int first = Math.min(cand[0], interval[0]);
                int second = Math.max(cand[1], interval[1]);
                cand = new int[]{first, second};
            }
        }
        tmp.add(cand);

        int[][] res = new int[tmp.size()][2];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }

        return res;
    }
}