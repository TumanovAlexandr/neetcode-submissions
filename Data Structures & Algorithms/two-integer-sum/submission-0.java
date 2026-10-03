class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (freq.containsKey(val)) {
                return new int[] {freq.get(val), i};
            }
            freq.put(nums[i],i);
        }

        return new int[] {0,0};
    }
}
