class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        int MOD = 1000000007;

        long[][] ways = new long[n][n];
        int[][] max = new int[n][n];

        for (int i = 0; i < n; i++)
            java.util.Arrays.fill(max[i], -1);

        ways[0][0] = 1;
        max[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;

                if (j > 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 3)
                        && ways[i][j - 1] > 0) {
                    ways[i][j] = (ways[i][j] + ways[i][j - 1]) % MOD;
                    max[i][j] = Math.max(max[i][j],
                            max[i][j - 1] + grid[i][j]);
                }

                if (i > 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3)
                        && ways[i - 1][j] > 0) {
                    ways[i][j] = (ways[i][j] + ways[i - 1][j]) % MOD;
                    max[i][j] = Math.max(max[i][j],
                            max[i - 1][j] + grid[i][j]);
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int) ways[n - 1][n - 1]);
        ans.add(ways[n - 1][n - 1] == 0 ? 0 : max[n - 1][n - 1]);

        return ans;
    }
}
