class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)

        for row in range(1, n):
            for col in range(row+1):
                minPath = float('inf')
                if col > 0:
                    minPath = triangle[row-1][col-1]
                if col < row:
                    minPath = min(minPath, triangle[row-1][col])
                triangle[row][col] += minPath
        
        return min(triangle[-1])
