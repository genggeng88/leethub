class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.size();
        int[][] dp = new int[m][n];
        for (int j=0; j<n; j++) dp[m-1][j] = triangle.get(m-1).get(j);

        for (int i=m-2; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}