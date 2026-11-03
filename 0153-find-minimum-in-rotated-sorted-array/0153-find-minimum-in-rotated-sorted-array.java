class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0];
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = i + (j - i)/2;
            if (nums[m] > nums[j]) i = m + 1;
            else j = m;
        }
        return nums[i];
    }
}