class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
/**
Questions:
1 <= nums.length <= 100
0 <= nums[i] <= 100
 0 1 2 3
[1,2,7,9]

[]
            []
          /    \
        1       2
       /  \       \
      7    9       9

rob = max(arr[0] + rob[2:n], rob[1:n])

TC: O(n), SC: O(n)
*/