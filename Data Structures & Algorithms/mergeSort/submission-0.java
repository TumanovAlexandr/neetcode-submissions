// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSort(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> mergeSort(List<Pair> pairs, int l, int r) {

        if (r - l + 1 <= 1) {
            return pairs;
        }
        
        int mid = l + (r - l) / 2;
        mergeSort(pairs, l, mid);
        mergeSort(pairs, mid + 1, r);
        merge(pairs, l, mid, r);

        return pairs;
    }

    private void merge(List<Pair> pairs, int l, int m, int r) {
        int length1 = m - l + 1;
        int length2 = r - m;

        // create temp arrays
        Pair[] left = new Pair[length1];
        Pair[] right = new Pair[length2];

        // fill temp arrays
        for (int i = 0; i < length1; i++) {
            left[i] = pairs.get(l + i);
        }

        for (int i = 0; i < length2; i++) {
            right[i] = pairs.get(m + i + 1);
        }

        int i = 0;
        int j = 0;
        int k = l;

        // merge two sorted
        while (i < length1 && j < length2) {
            if (left[i].key <= right[j].key) {
                pairs.set(k, left[i]);
                i++;
            } else {
                pairs.set(k, right[j]);
                j++;
            }
            k++;
        }

        while (i < length1) {
            pairs.set(k, left[i]);
            i++;
            k++;
        }

        while (j < length2) {
            pairs.set(k, right[j]);
            j++;
            k++;
        }
    }
}
/**
TC: O(n * log n), SC: O(n)
*/