class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        int[][] dp = new int[n+2][n+2];

        arr[0] = 1; arr[n+1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i+1] = nums[i];
        }

        for (int i = n+1; i >= 0; i--) {
            for (int j = i; j < n+2; j++) {
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
            }
        }

        return dp[0][n+1];
    }
}

// dp[0][n+1]: coins obtained by burst balloons from i+1 to j-1

// dp[i][j] = dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]