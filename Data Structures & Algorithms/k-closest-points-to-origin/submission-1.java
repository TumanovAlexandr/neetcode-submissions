class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int l = 0;
        int r = points.length - 1;
        int pivot = points.length;

        while (pivot != k) {
            pivot = quickSort(points, l, r);
            if (pivot < k) {
                l = l + 1;
            } else {
                r = r - 1;
            }
        }

        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private int quickSort(int[][] points, int l, int r) {
        int[] pivot = points[r];
        int pivotDist = euclidean(pivot);
        int left = l;

        for (int i = l; i < r; i++) {
            if (euclidean(points[i]) <= pivotDist) {
                swap(points, left, i);
                left++;
            }
        }

        swap(points, left, r);
        
        return left;
    }

    private void swap(int[][] points, int l, int r) {
        int[] temp = points[l];
        points[l] = points[r];
        points[r] = temp;
    }

    private int euclidean(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
/**
[[0,2],[2,2]] k = 1
   
[4,8]

TC: O(n), SC: O(1)
*/