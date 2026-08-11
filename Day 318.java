class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] pref = new int[n + 1][m + 1];

        // Build 2D prefix sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] = mat[i][j]
                        + pref[i][j + 1]
                        + pref[i + 1][j]
                        - pref[i][j];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] query : queries) {
            int r = query[0];
            int c = query[1];

            int maxRadius = Math.min(
                    Math.min(r, n - 1 - r),
                    Math.min(c, m - 1 - c)
            );

            // Check 1x1 square
            if (mat[r][c] > k) {
                ans.add(-1);
                continue;
            }

            int low = 0, high = maxRadius;
            int best = 0;

            // Binary search maximum valid radius
            while (low <= high) {
                int mid = low + (high - low) / 2;

                int top = r - mid;
                int bottom = r + mid;
                int left = c - mid;
                int right = c + mid;

                int ones = pref[bottom + 1][right + 1]
                         - pref[top][right + 1]
                         - pref[bottom + 1][left]
                         + pref[top][left];

                if (ones <= k) {
                    best = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            ans.add(2 * best + 1);
        }

        return ans;
    }
}
