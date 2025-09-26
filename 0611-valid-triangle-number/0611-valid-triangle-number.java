class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int cnt = 0;

        Arrays.sort(nums);

        for (int k=n-1; k>1; k--) {
            if (nums[k] == 0) break;
            int i=0, j=k-1;
            while (i < j) {
                if(nums[j] == 0) break;
                if(nums[i] == 0) {
                    i++;
                    continue;
                }
                long sum = (long) nums[i] + (long) nums[j];
                if (sum > nums[k]) {
                    cnt += j-i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return cnt;
    }
}