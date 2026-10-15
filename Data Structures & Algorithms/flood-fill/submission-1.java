class Solution {

    int m;
    int n;
    boolean[][] seen;
    int[][] directions = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
    int pixel;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        seen = new boolean[m][n];

        seen[sr][sc] = true;
        pixel = image[sr][sc];
        image[sr][sc] = color;
        dfs(image, sr, sc, color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color) {

        for (int[] direction : directions) {
            int row = r + direction[0];
            int col = c + direction[1];

            if (isValid(row, col, image) && !seen[row][col]) {
                seen[row][col] = true;
                image[row][col] = color;
                dfs(image, row, col, color);
                seen[row][col] = false;
            }
        }
    }

    private boolean isValid(int r, int c, int[][] image) {
        return r >= 0 && r < m && c >= 0 && c < n && image[r][c] == pixel;
    }
}
/**
Questions:
m == grid.length
n == grid[i].length
1 <= m, n <= 50
0 <= image[i][j], color < (2^16)
0 <= sr < m
0 <= sc < n

[1,1,0] sr=1 sc=1 color=2
[1,1,0]
[1,0,1]

[2,2,0]
[2,2,0]
[2,0,1]

TC: O(n * m), SC: O(n * m) 
*/