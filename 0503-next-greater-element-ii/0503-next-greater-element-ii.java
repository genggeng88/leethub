class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        if (nums.length == 1) return new int[]{-1};
        
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int num = nums[i % n];
            while (!deque.isEmpty() && num >= nums[deque.peekFirst()]) {
                deque.pollFirst();
            }
            if (i < n) {
                res[i] = deque.isEmpty() ? -1 : nums[deque.peekFirst()];
            }
            deque.offerFirst(i % n);
        }

        return res;
    }
}
