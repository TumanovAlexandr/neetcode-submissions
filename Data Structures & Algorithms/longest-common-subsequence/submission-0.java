class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (text1.charAt(r) == text2.charAt(c)) {
                    dp[r][c] = 1 + dp[r + 1][c + 1];
                } else {
                    dp[r][c] = Math.max(dp[r + 1][c], dp[r][c + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
/**
Questions:
1 <= length of 2 str <= 1000
test1 and text2 consist of only lowercase English letter

abcde

ace

e + lcs(abcd,ac) = 1 + lcs(abcd,ac)

                1 + max(2,1) = 3
                d!=c
               /   \
            abc     abcd
            ac      a
            1+1=2   1
        /    \         \
        ab   a          d!=a
        a    ""          /   \
        1     0      abc    abcd
                     a      "" 
                     1       0

        a b c d e
      a 3 2 2 1 1 0
      c 2 2 2 1 1 0
      e 1 1 1 1 1 0
        0 0 0 0 0 0

TC: O(n * m), SC: O(n * m)
*/