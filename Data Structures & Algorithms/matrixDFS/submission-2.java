class Solution {
    
    int m;
    int n;
    boolean[][] seen;
    int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return 0;
        }
        seen = new boolean[m][n];
        seen[0][0] = true;
        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int r, int c) {

        if (r == m - 1 && c == n - 1) {
            return 1;
        }
        int count = 0;
        for (int[] direction : directions) {
            int newRow = direction[0] + r;
            int newCol = direction[1] + c;
            
            if (isValid(newRow, newCol, grid) && !seen[newRow][newCol]) {
                seen[newRow][newCol] = true;
                count += dfs( grid, newRow, newCol);
                seen[newRow][newCol] = false;
            }
        }

        return count;
    }

    private boolean isValid(int r, int c, int[][] grid) {
        return r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 0;
    }
}
