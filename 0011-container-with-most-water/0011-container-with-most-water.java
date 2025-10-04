class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int l = 0, r = n-1;

        while (l < r) {
            int lh = height[l];
            int rh = height[r];
            maxArea = Math.max(maxArea, Math.min(lh, rh) * (r - l));
            if (lh < rh) l++;
            else r--;
        }

        return maxArea;
    }
}