class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefix[i] *= suffix;
            suffix *= nums[i];
        }
        return prefix;
    }
}  
/**
Questions:
2 <= nums.length <= 100,000
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

[1,2,4,6]
     ^i
[1,1,12,8]
     ^i
prefix sum
suffix

TC: O(n), SC: O(n)
*/