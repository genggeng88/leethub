class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) {
                if (nums[m] <= nums[j]) {
                    if (target <= nums[j]) i = m+1;
                    else j = m-1;
                }
                else i = m + 1;
            }
            else {
                if (nums[m] <= nums[j]) {
                    j = m-1;
                }
                else {
                    if (target >= nums[i]) j = m-1;
                    else i = m+1;
                }
            }
        }
        return -1;
    }
}

// ------ |
//          -------
//             m           

// ------ |
//          -------
//   m t                