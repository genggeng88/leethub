class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        Map<Integer, Integer> mapping = new HashMap<>();
        int i=0, j=1, cnt=1, maxFreq=1;
        Arrays.sort(nums);
        while (j < n) {
            int a = nums[i], b = nums[j];
            if (a == b) {
                cnt++;
            } else {
                maxFreq = Math.max(maxFreq, cnt);
                mapping.put(cnt, mapping.getOrDefault(cnt, 0)+1);
                cnt=1;
            }
            i++; j++;
            if (j == n) {
                maxFreq = Math.max(maxFreq, cnt);
                mapping.put(cnt, mapping.getOrDefault(cnt, 0)+1);
            }
        }

        return maxFreq * mapping.get(maxFreq);
    }
}