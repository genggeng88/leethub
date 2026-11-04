class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String cand = "";
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) dp[i][j] = true;
                else if (i+1 == j) dp[i][j] = s.charAt(i) == s.charAt(j);
                else {
                    if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j] && j - i + 1 > cand.length()) {
                    cand = s.substring(i, j+1);
                }
            }
        }
        return cand;
    }
}

//   b a b a d
// b T
// a
// b
// a
// d

// boolean
// dp[i][j]: substring s[i, j+1] is palindromic