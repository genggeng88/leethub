class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, cnt = 0;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            cnt += num - min;
        }
        return cnt;
    }
}