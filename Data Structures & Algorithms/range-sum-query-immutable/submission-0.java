class NumArray {

    List<Integer> prefix;

    public NumArray(int[] nums) {
        prefix = new ArrayList<>();
        prefix.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            prefix.add(prefix.get(i - 1) + nums[i]);
        }
    }
    
    public int sumRange(int left, int right) {
        int rightSum = prefix.get(right);
        int leftSum = left == 0 ? 0 : prefix.get(left - 1);
        return rightSum - leftSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */