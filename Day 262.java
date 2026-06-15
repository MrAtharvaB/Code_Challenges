class Solution {
    public int minimumCost(int[] cost, int w) {
        int INF = (int)1e9;

        int[] dp = new int[w + 1];
        for (int i = 1; i <= w; i++) {
            dp[i] = INF;
        }

        dp[0] = 0;

        int n = cost.length;

        for (int i = 0; i < n; i++) {
            if (cost[i] == -1) continue;

            int weight = i + 1;

            for (int j = weight; j <= w; j++) {
                dp[j] = Math.min(dp[j], dp[j - weight] + cost[i]);
            }
        }

        return dp[w] == INF ? -1 : dp[w];
    }
}
