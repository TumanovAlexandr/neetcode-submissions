class Solution {

    int m;
    int n;
    boolean[][] seen;
    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int count;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1' && !seen[r][c]) {
                    count++;
                    seen[r][c] = true;
                    dfs(grid, r, c);
                }
            }
        }

        return count; 
    }

    private void dfs(char[][] grid, int r, int c) {
        for (int[] direction : directions) {
            int row = direction[0] + r;
            int col = direction[1] + c;
            if (isValid(row, col, grid) && !seen[row][col]) {
                seen[row][col] = true;
                dfs(grid, row, col);
            }
        }
    }

    private boolean isValid(int r, int c, char[][] grid) {
        return r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1';
    }
}
/**
Questions:
1 <= grid.length, grid[i].length <= 100
grid[i][j] is '0' or '1'.

[1,1,0]
[1,1,0]
[0,0,1]

count = 2
TC: O(n * m), SC: O(n * m)
*/