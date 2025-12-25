import java.util.*;

class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int top = 0, bottom = n - 1;

        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            int maxCol = 0;

            for (int j = 1; j < m; j++) {
                if (mat[mid][j] > mat[mid][maxCol]) {
                    maxCol = j;
                }
            }

            int curr = mat[mid][maxCol];
            int up = (mid > 0) ? mat[mid - 1][maxCol] : Integer.MIN_VALUE;
            int down = (mid < n - 1) ? mat[mid + 1][maxCol] : Integer.MIN_VALUE;

            if (curr >= up && curr >= down) {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(mid);
                ans.add(maxCol);
                return ans;
            }

            if (down > curr) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }

        return new ArrayList<>(Arrays.asList(0, 0));
    }
}
