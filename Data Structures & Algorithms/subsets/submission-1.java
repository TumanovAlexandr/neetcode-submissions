class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int i, List<Integer> curr, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(nums[i]);
        backtrack(nums, i + 1, curr, res);
        curr.remove(curr.size() - 1);
        backtrack(nums, i + 1, curr, res);
    }
}
/**
Questions:
1 <= nums.length <= 10
-10 <= nums[i] <= 10

             []
          /  |  \
         1   2   3
       / |   |
      2  3   3
     /
    3  

TC: O(n * 2^n), SC: O(n)
*/