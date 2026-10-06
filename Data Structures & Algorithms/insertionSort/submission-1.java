// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> res = new ArrayList<>();
        for (int i = 0; i < pairs.size(); i++) {
            int j = i - 1;
            while (j >= 0 && pairs.get(j + 1).key < pairs.get(j).key) {
                swap(j + 1, j, pairs);
                j--;
            }
            res.add(new ArrayList<>(pairs));
        }
        return res;
    }

    private void swap(int l, int r, List<Pair> pairs) {
        Pair tmp = pairs.get(l);
        pairs.set(l, pairs.get(r));
        pairs.set(r, tmp);
    }
}
/**
[2,3,4,1,6]
       ^i
     ^j
TC: O(n^2), SC: O(1)
*/