class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            int lastBits = n & 1;
            res = res | lastBits;
            n = n >> 1;          
        }
        return res;
    }
}
/**
TC: O(1), SC: O(1)
*/