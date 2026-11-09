class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int num = s.charAt(i-1) - '0';
            if (num > 0) {
                dp[i] += dp[i-1];
            }

            if (s.charAt(i - 2) - '0' > 0 && (s.charAt(i - 2) - '0') * 10 + num <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}

// dp[i]: number of ways for substring(0, i) exclusive i
// dp[0] = 0
// dp[1] = 1
// dp[2] = dp[0] if num[0] > 0 && 0 < num[0,1] <= 26. 
//       + dp[1] if num[1] > 0