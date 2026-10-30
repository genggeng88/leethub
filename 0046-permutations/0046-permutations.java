class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        dfs(0, res, nums);
        return res;
    }

    private void dfs(int idx, List<List<Integer>> res, int[] nums) {
        if (idx == nums.length - 1) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            res.add(tmp);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            dfs(idx+1, res, nums);
            swap(nums, i, idx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}