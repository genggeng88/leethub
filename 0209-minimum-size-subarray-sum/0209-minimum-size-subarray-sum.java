class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0, i = 0, j = 0, sum = 0;

        while (j <= nums.length && i < nums.length) {
            if (j < nums.length && sum < target) {
                sum += nums[j];
                j++;
            }else {
                sum -= nums[i];
                i++;
            }
            if (sum >= target) {
                if (res == 0 || res > j - i) res = j - i;
            }
        }
        return res;
    }
}
// 7
// 2 3 1 2 4 3
//         i
//             j
// sum = 7
// res = 2