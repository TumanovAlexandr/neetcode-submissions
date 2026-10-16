class Solution {

    int m;
    int n;
    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int shortestPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[2]);
        seen[0][0] = true;

        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];

                if (r == m - 1 && c == n - 1) {
                    return length;
                }

                for (int[] direction : directions) {
                    int row = direction[0] + r;
                    int col = direction[1] + c;
                    if (isValid(grid, row, col) && !seen[row][col]) {
                        seen[row][col] = true;
                        queue.add(new int[]{row, col});
                    }
                }
            }
            length++;
        }
        return -1;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 0;
    }
}
/**
Questions:
?

[0,0,0]
[1,0,1]
[0,0,0]
*/