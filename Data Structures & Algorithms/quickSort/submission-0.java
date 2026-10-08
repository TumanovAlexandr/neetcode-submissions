// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return quickSort(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> quickSort(List<Pair> pairs, int l, int r) {
        if (r - l + 1 <= 1) {
            return pairs;
        }

        Pair pivot = pairs.get(r);
        int left = l;

        // partition: element smaller than pivot on left side 
        for (int i = l; i < r; i++) {
            if (pairs.get(i).key < pivot.key) {
                swap(pairs, i, left);
                left++;
            }
        }

        // move pivot in-between left and right sides
        pairs.set(r, pairs.get(left));
        pairs.set(left, pivot);

        quickSort(pairs, l, left - 1);
        quickSort(pairs, left + 1, r);

        return pairs;
    }

    private void swap(List<Pair> pairs, int l, int r) {
        Pair pair = pairs.get(l);
        pairs.set(l, pairs.get(r));
        pairs.set(r, pair);
    }
}
