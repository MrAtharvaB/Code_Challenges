import java.util.*;

class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] height = new int[n][m];

        for (int j = 0; j < m; j++) {
            height[0][j] = mat[0][j];

            for (int i = 1; i < n; i++) {
                if (mat[i][j] == 1) {
                    height[i][j] = height[i - 1][j] + 1;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            Integer[] row = new Integer[m];

            for (int j = 0; j < m; j++) {
                row[j] = height[i][j];
            }

            Arrays.sort(row, Collections.reverseOrder());

            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, row[j] * (j + 1));
            }
        }

        return ans;
    }
}
