class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);

        for (int num : nums) {
            heap.offer(num);
        }

        while (k - 1 > 0) {
            heap.poll();
            k--;
        }

        return heap.peek();
    }
}
/**
Questions:
1 <= k <= nums.length <= 10000
-1000 <= nums[i] <= 1000

[2,3,1,4,5] k = 2

[5,4,3,2,1]
   ^i

4
TC: O(n * log n), SC: O(n)
*/