class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0;
        int r = rows * cols - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int row = m / cols;
            int col = m % cols;
            if (target > matrix[row][col]) {
                l = m + 1;
            } else if (target < matrix[row][col]) {
                r = m - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}

/**
[1,3,5,7]
[10,11,16,20]
[23,30,34,60]

l = 0 r = 3 * 4 - 1 = 11
m = 11 / 2 = 5
row = 5 / 3 = 1
col = 5 % 4 = 1
r = 5 - 1 = 4

*/