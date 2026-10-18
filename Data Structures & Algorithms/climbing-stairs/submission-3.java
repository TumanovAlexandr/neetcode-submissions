class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
/**
Questions:

[1,2,3]     n = 3

        3
      /   \
     1     2
   /  \   / \
  1    2 1   2
 /
1      

f(n) = f(n - 1) + f(n - 2)

res = 3

TC: O(n), SC: O(n)
*/