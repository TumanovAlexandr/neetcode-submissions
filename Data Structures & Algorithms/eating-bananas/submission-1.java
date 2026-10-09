class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        
        for (int pile : piles) {
            high = Math.max(pile, high);
        }
        
        while (low <= high) {
            int m = low + (high - low) / 2;
            if (hoursSpeed(piles, m) <= h) {
                high = m - 1;
            } else {
                low = m + 1;
            }
        }

        return low;
    }

    private long hoursSpeed(int[] piles, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1L) / k;
        }
        return hours;
    }
}
/**
 0 1 2 3
[1,4,3,2]   h = 9
   ^i
k = 9 / 4 = 2
I can eat 2 bananas per hour
1 + 2 + 2 + 1 = 6
1,2,3,4
^l
      ^h
  ^m
m = 2 / 2 = 1
1 + 4 + 3 + 2 = 10
10 <= 9
m = 3 / 2 = 1
10 <= 9
m = 4 / 2 = 2
1 + 2 + 2 + 1 = 6
TC: O(n * log m), SC: O(1)
*/