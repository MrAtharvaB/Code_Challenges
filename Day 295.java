class Solution {
    static final int MOD = 1000000007;

    public int findWays(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] suff = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                suff[i][j] = matrix[i][j]
                        + suff[i + 1][j]
                        + suff[i][j + 1]
                        - suff[i + 1][j + 1];
            }
        }

        int[][][] dp = new int[k + 1][n][m];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (suff[r][c] > 0)
                    dp[1][r][c] = 1;
            }
        }

        for (int rem = 2; rem <= k; rem++) {

            int[][] dpSumRow = new int[n + 1][m];
            int[][] dpSumCol = new int[n][m + 1];

            for (int r = n - 1; r >= 0; r--) {
                for (int c = m - 1; c >= 0; c--) {
                    dpSumRow[r][c] = (dp[rem - 1][r][c] + dpSumRow[r + 1][c]) % MOD;
                    dpSumCol[r][c] = (dp[rem - 1][r][c] + dpSumCol[r][c + 1]) % MOD;
                }
            }

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {

                    if (suff[r][c] == 0)
                        continue;

                    long ways = 0;

                    int nr = findNextRow(suff, r, c, n);
                    if (nr < n)
                        ways = (ways + dpSumRow[nr][c]) % MOD;

                    int nc = findNextCol(suff, r, c, m);
                    if (nc < m)
                        ways = (ways + dpSumCol[r][nc]) % MOD;

                    dp[rem][r][c] = (int) ways;
                }
            }
        }

        return dp[k][0][0];
    }

    private int findNextRow(int[][] suff, int r, int c, int n) {
        int low = r + 1;
        int high = n;
        int ans = n;
        int target = suff[r][c];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (suff[mid][c] < target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private int findNextCol(int[][] suff, int r, int c, int m) {
        int low = c + 1;
        int high = m;
        int ans = m;
        int target = suff[r][c];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (suff[r][mid] < target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
