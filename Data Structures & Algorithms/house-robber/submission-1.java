class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int rob(int[] nums) {
        return dfs(0, nums);
    }

    private int dfs(int i, int[] nums) {
        if (i >= nums.length) {
            return 0;

        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        memo.put(i, Math.max(dfs(i + 1, nums), nums[i] + dfs(i + 2, nums)));
        return memo.get(i);
    }
}
/**
Questions:
1 <= nums.length <= 100
0 <= nums[i] <= 100
 0 1 2 3
[1,2,7,9]


            []
          /    \
        1       2
       /  \       \
      7    9       9

rob = max(arr[0] + rob[2:n], rob[1:n])

TC: O(2^n), SC: O(n)
*/