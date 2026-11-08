class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();     // prefixSum, cnt
        int n = nums.length, prefixSum = 0, cnt = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - goal)) {
                cnt += map.get(prefixSum - goal);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return cnt;
    }
}