class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int i = 0, j = height.length - 1;
        int left = height[0], right = height[j];
        int water = 0;
        while (i < j) {
            if (left < right) {
                i++;
                if (height[i] > left) left = height[i];
                else water += (left - height[i]);
            }
            else {
                j--;
                if (height[j] > right) right = height[j];
                else water += right - height[j];
            }
        }
        return water;
    }
}