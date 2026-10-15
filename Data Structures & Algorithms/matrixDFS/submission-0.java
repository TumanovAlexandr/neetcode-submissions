class Solution {
    
    int m;
    int n;

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        return dfs(grid, 0, 0, seen);
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] seen) {
        if (!isValid(r, c, grid) || seen[r][c]) {
            return 0;
        }
        if (r == m - 1 && c == n - 1) {
            return 1;
        }
        seen[r][c] = true;
        int count = 0;
        count += dfs(grid, r + 1, c, seen);
        count += dfs(grid, r - 1, c, seen);
        count += dfs(grid, r, c + 1, seen);
        count += dfs(grid, r, c - 1, seen);
        seen[r][c] = false;
        return count;
    }

    private boolean isValid(int r, int c, int[][] grid) {
        return r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 0;
    }
}
/**
TC: O(4^m*^n), SC: O(m * n)
*/