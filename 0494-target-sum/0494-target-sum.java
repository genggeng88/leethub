class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] cnt = new int[]{0};
        dfs(0, 0, nums, target, cnt);
        return cnt[0];
    }

    private void dfs(int idx, int sum, int[] nums, int target, int[] cnt) {
        if (idx == nums.length) {
            if (sum == target) cnt[0]++;
            return;
        }
        dfs(idx + 1, sum + nums[idx], nums, target, cnt);
        dfs(idx + 1, sum - nums[idx], nums, target, cnt);
    }
}