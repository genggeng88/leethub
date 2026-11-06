class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int maxArea = 0;
	    Deque<Integer> stack = new ArrayDeque<>();
	    stack.offerFirst(-1);
        
        for (int i = 0; i <= heights.length; i++) {
            while (stack.peekFirst() != -1 && (i == heights.length || heights[stack.peekFirst()] >= heights[i])) {
                int h = heights[stack.pollFirst()];
                int l = stack.peekFirst() + 1;
                int area = h * (i - l);
                maxArea = Math.max(maxArea, area);
                
            }
            if (i < heights.length) stack.offerFirst(i);
        }

        return maxArea;
    }
}