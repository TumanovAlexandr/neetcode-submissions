class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            left += nums[i];
            int right = total - left + nums[i];
            if (left == right) {
                return i;
            }
        }

        return -1;
    }
}
/**
Questions:
1 <= nums.length <= 10,000
-1,000 <= nums[i] <= 1,000
 0 1 2 3 4 5
[1,7,3,6,5,6]
       ^i

total = 28
left = 17
right = 

TC: O(n), SC: O(1)
*/