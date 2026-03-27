class Solution {
    public int maxChocolate(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    int max = 0;

                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {

                            int nj1 = j1 + d1;
                            int nj2 = j2 + d2;

                            if (nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m) {
                                int val = dp[i + 1][nj1][nj2];

                                if (j1 == j2)
                                    val += grid[i][j1];
                                else
                                    val += grid[i][j1] + grid[i][j2];

                                max = Math.max(max, val);
                            }
                        }
                    }

                    dp[i][j1][j2] = max;
                }
            }
        }

        return dp[0][0][m - 1];
    }
}
