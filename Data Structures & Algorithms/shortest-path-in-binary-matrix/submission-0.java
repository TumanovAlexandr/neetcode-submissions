class Solution {

    int m;
    int n;

    public int shortestPathBinaryMatrix(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        int[][] directions = new int[8][];
        int d = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                directions[d++] = new int[]{i,j};
            }
        }

        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[2]);
        seen[0][0] = true;

        int length = 1;
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
                        queue.add(new int[]{row,col});
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