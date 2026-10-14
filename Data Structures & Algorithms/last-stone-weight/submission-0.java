class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            heap.add(stone);
        }

        while (!heap.isEmpty()) {
            if (heap.size() == 1) {
                break;
            }
            int first = heap.poll();
            int second = heap.poll();

            if (first > second) {
                heap.offer(first - second);
            }
        }

        if (!heap.isEmpty()) {
            return heap.peek();
        } else {
            return 0;
        }
    }
} // TC: O(n * log n), SC: O(n)
/**
Questions:
1 <= stone.length <= 20
1 <= stones[i] <= 100

[2,3,6,2,4]
 ^i

[1]


*/