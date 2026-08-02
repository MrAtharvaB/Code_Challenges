class Solution {
    public int count(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        // Base case
        for (int i = 1; i <= m; i++) {
            dp[1][i] = 1;
        }

        // DP
        for (int len = 2; len <= n; len++) {
            for (int cur = 1; cur <= m; cur++) {
                for (int prev = 1; prev <= m; prev++) {
                    if (cur % prev == 0 || prev % cur == 0) {
                        dp[len][cur] += dp[len - 1][prev];
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans += dp[n][i];
        }

        return ans;
    }
}
