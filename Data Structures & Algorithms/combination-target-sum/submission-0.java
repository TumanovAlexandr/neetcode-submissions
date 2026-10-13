class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int target, int i, int sum, List<Integer> curr, List<List<Integer>> res) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            backtrack(nums, target, j, sum + nums[j], curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
/**
Questions:
all elements of nums are distinct
1 <= nums.length <= 20
2 <= nums[i] <= 30
2 <= target <= 30

            9
          / |  \  \
         2  5   6  9 t

TC: O(2^n), SC: O(n)
*/