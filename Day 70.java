class Solution {
    public int minCost(int keys[], int freq[]) {
        int n = keys.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][n];
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + freq[i];
        }

        java.util.function.BiFunction<Integer, Integer, Integer> sumFreq = (i, j) ->
                prefix[j + 1] - prefix[i];
        for (int i = 0; i < n; i++) {
            dp[i][i] = freq[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int totalFreq = sumFreq.apply(i, j);
                for (int r = i; r <= j; r++) {
                    int leftCost = (r > i) ? dp[i][r - 1] : 0;
                    int rightCost = (r < j) ? dp[r + 1][j] : 0;
                    int cost = leftCost + rightCost + totalFreq;

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
