class Solution {

    int m;
    int n;
    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int count = dfs(grid, r, c);
                    maxArea = Math.max(maxArea, count);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        int count = 1;
        grid[r][c] = 0;
        for (int[] direction : directions) {
            int row = direction[0] + r;
            int col = direction[1] + c;

            if (isValid(grid, row, col)) {
                grid[row][col] = 0;
                count += dfs(grid, row, col);
            }
        }
        return count;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1;
    }
}
/**
Questions:
1 <= grid.length, grid[i].length <= 50

[0,1,0]
[1,0,1]
[1,0,1]

max(1,0) = 1 -> max(2,1) = 2

TC: O(n * m), SC: O(m * m)
*/