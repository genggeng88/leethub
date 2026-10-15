class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        long sum = 0;

        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        
        return (int) (sum - min * n);
    }
}