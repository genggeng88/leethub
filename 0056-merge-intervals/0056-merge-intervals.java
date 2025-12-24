class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return null;

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        List<int[]> result = new LinkedList<>();
        result.add(intervals[0]);

        for (int i=1; i<intervals.length; i++) {
            int[] prev = result.get(result.size()-1);
            if (prev[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}