class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        if (k == 1) return nums;
        int n = nums.length, p = 0;
        int[] res = new int[n - k + 1];
        Deque<Integer> mono = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (i >= k && mono.peekFirst() == nums[i - k]) mono.pollFirst();
            
            while (!mono.isEmpty() && mono.peekLast() < nums[i]) {
                mono.pollLast();
            }
            mono.offerLast(nums[i]);
            
            if (i >= k-1) {
                res[p++] = mono.peekFirst();
            }
        }
        return res;
    }
}
// 0 1 2
// 7 2 4
// i
// [