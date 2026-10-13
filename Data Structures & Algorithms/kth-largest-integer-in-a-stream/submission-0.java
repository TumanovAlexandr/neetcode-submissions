class KthLargest {

    Queue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        heap.add(val);
        while (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
/**
Questions:
1 <= k <= 1000
0 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-1000 <= val <= 1000

TC: O()
*/