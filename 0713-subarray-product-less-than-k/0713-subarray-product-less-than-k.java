class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int n = nums.length, cnt = 0, l = 0;
        long prod = 1L;

        for (int i = 0; i < n; i++) {
            prod *= nums[i];
            while (prod >= k) {
                prod /= nums[l];
                l++;
            }
            cnt += i - l + 1;
        }
        return cnt;
    }
}
