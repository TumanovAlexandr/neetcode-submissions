class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];

        for (int r = m - 1; r >= 0; r--) {
            int[] currRow = new int[n];
            currRow[n - 1] = 1;
            for (int c = n - 2; c >= 0; c--) {
                currRow[c] = currRow[c + 1] + prevRow[c];
            }

            prevRow = currRow;
        }

        return prevRow[0];
    }
}
/**
Questions:
1 <= m, n <= 100

[6,3,1] cr
[3,2,1] pr
[1,1,1] 
 0,0,0  

TC: O(n * m), SC: O(m)
*/