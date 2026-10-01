class Solution {
    public int[] getConcatenation(int[] nums) {
        int capacity = nums.length * 2;
        int[] arr = new int[capacity];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
            arr[capacity - nums.length + i] = nums[i];
        }
        return arr;
    }
}