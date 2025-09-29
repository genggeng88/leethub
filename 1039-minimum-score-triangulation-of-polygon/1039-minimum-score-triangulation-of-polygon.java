class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        for (int i=0; i<n-2; i++) {
            dp[i][i+2] = values[i] * values[i+1] * values[i+2];
        }

        for (int i=n-4; i>=0; i--) {
            for (int j=i+3; j<n; j++) {
                int k=i+1;
                dp[i][j] = dp[i][k] + dp[k][j] + values[i] * values[j] * values[k];
                k++;
                for (; k<j; k++) {
                    dp[i][j] = Math.min(dp[i][j], 
                                        dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
                }
            }
        }

        return dp[0][n-1];
    }
}