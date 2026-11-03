class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum %2 != 0) return false;
        int subSum = sum / 2;
        boolean[] dp = new boolean[subSum+1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            int curr = nums[i-1];
            for (int j = subSum; j >= curr; j--) {
                dp[j] = dp[j] || dp[j - curr];
            }
        }
        return dp[subSum];
    }
}

// 1 3 5 8 9 10 => 36 => 18
// -----   -- 

// dp[i][j]: can have subsum j with at most i numbers 
// for each curr:
//     choose curr dp[i-1][j-curr]
//     no choose curr dp[i-1][j]