class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] toRight = new int[n];
        int[] toLeft = new int[n];
        toRight[0] = 1; toLeft[n-1] = 1;
        for (int i = 1; i < n; i++) {
            toRight[i] = toRight[i-1] * nums[i-1];
        }
        for (int i = n-2; i >= 0; i--) {
            toLeft[i] = toLeft[i+1] * nums[i+1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = toRight[i] * toLeft[i];
        }
        return res;
    }
}