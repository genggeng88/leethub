class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum) return 0;
        if ((target + sum) % 2 != 0) return 0;
        
        int targetSum = (sum + target) / 2;
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = targetSum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[targetSum];
    }
}