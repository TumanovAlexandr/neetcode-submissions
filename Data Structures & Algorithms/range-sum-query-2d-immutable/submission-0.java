class NumMatrix {

    int m;
    int n;
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        prefix = new int[m + 1][n + 1];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                prefix[r + 1][c + 1] = matrix[r][c] + prefix[r][c + 1] + prefix[r + 1][c] - prefix[r][c];
            }
        }
    }

    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1];
    }
}

/**
[1,2,3]
[2,3,1]
[6,3,5]
 
[0,0,0,0]
[0,1,3,6]
[0,3,8,12]
[0,6,17,26]

*/

/**
 * 0Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */