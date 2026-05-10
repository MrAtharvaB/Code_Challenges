import java.util.*;

class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (i, j) -> 
            Integer.compare(Math.abs(b[j] - a[j]), Math.abs(b[i] - a[i]))
        );

        int profit = 0;

        for (int id : idx) {
            if ((a[id] >= b[id] && x > 0) || y == 0) {
                profit += a[id];
                x--;
            } else {
                profit += b[id];
                y--;
            }
        }

        return profit;
    }
}
