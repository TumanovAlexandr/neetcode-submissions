class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0,1);
        int currSum = 0;
        int res = 0;
        for (int num : nums) {
            currSum += num;
            int diff = currSum - k;
            if (prefix.containsKey(diff)) {
                res += prefix.get(diff);
            }
            prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }
}
/**
Questions:
1 <= nums.length <= 20,000
-1,000 <= nums[i] <= 1,000
-10,000,000 <= k <= 10,000,000

[2,-1,1,2] k = 2
        ^i

{0:1,2:2,1:1,4:1}
curSum = 0
count = 4
TC: O(n), SC: O(n)
*/