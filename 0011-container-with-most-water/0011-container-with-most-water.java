class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            int area = h * (r - l);
            maxArea = Math.max(maxArea, area);
            if (height[l] < height[r]) l++;
            else r--;
        }
        return maxArea;
    }
}