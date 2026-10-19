class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
/**
Questions:
0 <= n <= 2^31 - 1

TC: O(1), SC: O(1)
*/