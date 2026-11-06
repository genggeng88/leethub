class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int maxArea = 0;
	    Deque<Integer> stack = new ArrayDeque<>();
	    stack.offerFirst(-1);
        
        for (int i = 0; i < heights.length; i++) {
            while (stack.peekFirst() != -1 && heights[stack.peekFirst()] >= heights[i]) {
                int r = i;
                int h = heights[stack.pollFirst()];
                int l = stack.peekFirst() + 1;
                int area = h * (r - l);
                maxArea = Math.max(maxArea, area);
                
            }
            stack.offerFirst(i);
        }
        
        int r = heights.length;
        while (stack.peekFirst() != -1) {
            int h = heights[stack.pollFirst()];
            int l = stack.peekFirst() + 1;
            int area = h * (r - l);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}