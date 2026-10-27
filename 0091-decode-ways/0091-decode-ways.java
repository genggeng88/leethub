class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        if (arr[0] == '0') return 0;
        int[] dp = new int[arr.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= arr.length; i++) {
            if (arr[i-2] == '0') {
                if (arr[i-1] == '0') return 0;
                dp[i] = dp[i-1];
                continue;
            }
            if (arr[i-1] == '0') {
                if (arr[i-2] == '1' || arr[i-2] == '2') dp[i] = dp[i-2];
                else return 0;
            }
            else if (arr[i-1] > '6') {
                if (arr[i-2] == '1') dp[i] = dp[i-2] + dp[i-1];
                else dp[i] = dp[i-1];
            }
            else {
                if (arr[i-2] == '1' || arr[i-2] == '2') dp[i] = dp[i-1] + dp[i-2];
                else dp[i] = dp[i-1];
            }
        }
        return dp[arr.length];
    }
}


// dp[i] if char[i] == '0' 
//             if (char[i-1] == '1' || char[i-1] == '2') dp[i] = dp[i-1];
//             else return 0;
//       else if char[i] > '6'
//             if (char[i-1] == '1') dp[i] = dp[i-2] + dp[i-1]
//             else dp[i] = dp[i-1];
//       else char[i] (0, 6]:
//             if (char[i-1] == '1' || char[i-1] == '2') dp[i] = dp[i-1] + dp[i-2];
//             else dp[i] = dp[i-1]