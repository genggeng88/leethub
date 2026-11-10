class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null) return secondList;
        if (secondList == null) return firstList;
        
        int m = firstList.length, n = secondList.length;
        int f = 0, s = 0;
        List<int[]> tmp = new ArrayList<>();
        while (f < m && s < n) {
            int[] first = firstList[f];
            int[] second = secondList[s];

            int start = Math.max(first[0], second[0]);
            int end = Math.min(first[1], second[1]);

            // overlap
            if (start <= end) {
                tmp.add(new int[]{start, end});
                if (first[1] > second[1]) {
                    s++;
                }
                else if (first[1] < second[1]) {
                    f++;
                }
                else{
                    f++;
                    s++;
                }
            }
            else {
                if (first[1] < second[0]) f++;
                else s++;
            }
        }
        int[][] res = new int[tmp.size()][2];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
}
