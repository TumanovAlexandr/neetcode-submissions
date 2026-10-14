class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> heap = new PriorityQueue<>((a,b) -> euclidean(b) - euclidean(a));

        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] res = new int[k][];
        for (int i = 0; i < res.length; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    private int euclidean(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
/**
Questions:
1 <= k <= points.length <= 1000
-100 <= points[i][0], points[i][1] <= 100

[[0,2],[2,2]]  k = 1
         ^i
[4]

TC: O(n * log n), SC: O(n)
*/