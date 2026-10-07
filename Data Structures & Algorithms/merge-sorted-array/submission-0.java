class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }

        mergeSort(nums1, 0, nums1.length - 1);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (r - l + 1 <= 1) {
            return;
        }

        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    private void merge(int[] arr, int l, int m, int r) {
        int length1 = m - l + 1;
        int length2 = r - m;

        int[] left = new int[length1];
        int[] right = new int[length2];

        for (int i = 0; i < length1; i++) {
            left[i] = arr[l + i];
        }

        for (int i = 0; i < length2; i++) {
            right[i] = arr[m + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < length1 && j < length2) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < length1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < length2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
/**
 0 1 2 3 4
[4,6,8,1,2] m=3    
 ^k
 ^i
[1,2] n=2
 ^j

TC: O(n * log n), SC: O(n)
*/