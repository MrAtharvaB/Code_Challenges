import java.util.*;

class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        int k = arr.length;

        int[] rows = new int[k];
        int[] cols = new int[k];

        for (int i = 0; i < k; i++) {
            rows[i] = arr[i][0];
            cols[i] = arr[i][1];
        }

        Arrays.sort(rows);
        Arrays.sort(cols);

        int maxRows = getMaxGap(rows, n);
        int maxCols = getMaxGap(cols, m);

        return maxRows * maxCols;
    }

    private int getMaxGap(int[] blocked, int limit) {
        int prev = 0;
        int maxGap = 0;

        for (int x : blocked) {
            maxGap = Math.max(maxGap, x - prev - 1);
            prev = x;
        }

        maxGap = Math.max(maxGap, limit - prev);

        return maxGap;
    }
}
