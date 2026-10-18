class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n - 1] = 1;

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                } else {
                    dp[r][c] = dp[r + 1][c] + dp[r][c + 1];
                }
            }
        }

        return dp[0][0];
    }
}
/**
Questions:
range of m and n? 1 <= m, n <= 100
0 or 1?

[0,0,0]
[0,0,0]
[0,1,0]
 
[3,2,1,0] 
[1,1,1,0]
[0,0,1,0]
[0,0,1,0]

TC: O(n * m), SC: O(m)
*/