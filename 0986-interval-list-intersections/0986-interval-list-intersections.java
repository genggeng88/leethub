class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || firstList.length == 0) return new int[][]{};
        if (secondList == null || secondList.length == 0) return new int[][]{};

        int i = 0, j = 0, m = firstList.length, n = secondList.length;
        int[] first = new int[2], second = new int[2];
        List<int[]> buffer = new ArrayList<>();
        // double check condition
        while (i < m && j < n) {
            first = firstList[i];
            second = secondList[j];
            int start = Math.max(first[0], second[0]);
            int end = Math.min(first[1], second[1]);
            if (start <= end) {
                int[] inter = new int[]{start, end};
                buffer.add(inter);
                if (first[1] < second[1]) {
                    i++;
                }
                else if (second[1] < first[1]) {
                    j++;
                }
                else {
                    i++;
                    j++;
                }
            }
            else {
                if (first[1] < second[1]) i++;
                else j++;
            }

        }
        return buffer.toArray(new int[buffer.size()][]);
    }
}

// two pointers: i, j
//     one = first[i]
//     two = second[j]
//     if overlap
//         get intersection, put into res
//         // [max(one[0], two[0]), min(one[1], two[1]]
//         // update one interval for next compare
//         if (one[1] < two[1]) {
//             i++;
//         }
//         else if (one[1] > two[1]) {
//             j++;
//         }
//     else 
//         i++;
//         j++;