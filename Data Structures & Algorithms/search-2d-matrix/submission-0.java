class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target > arr[m]) {
                l = m + 1;
            } else if (target < arr[m]) {
                r = m - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}

/**
[1,2,3]
[4,5,6]
[7,8,9]
TC: O(n * log n), SC: O(1)
*/