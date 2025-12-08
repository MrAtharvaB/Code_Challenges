class Solution {
    public String matrixChainOrder(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] split = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
        }

        return buildOrder(split, 1, n - 1);
    }

    private String buildOrder(int[][] split, int i, int j) {
        if (i == j)
            return String.valueOf((char)('A' + i - 1));

        return "(" + buildOrder(split, i, split[i][j]) +
                buildOrder(split, split[i][j] + 1, j) + ")";
    }
}
