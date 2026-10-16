class Solution {

    int m;
    int n;
    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        int freshCount = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r,c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];

                for (int[] direction : directions) {
                    int row = direction[0] + r;
                    int col = direction[1] + c;

                    if (isValid(grid, row, col)) {
                        grid[row][col] = 2;
                        freshCount--;
                        queue.add(new int[]{row,col});
                    }
                }
            }
            minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1;
    }
}

/**
Questions:
1 <= grid.length, grid[0].length <= 10

[1,1,0]
[0,1,1]
[0,1,2]

[1,1,1]
[0,0,1]
[1,0,2]


TC: O(n * m), SC: O(n * m)
*/