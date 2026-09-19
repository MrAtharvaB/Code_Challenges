class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        int n = s1.length();
        int m = s2.length();

        long[][] dp = new long[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = (long) i * costS1;
        }

        for (int j = 1; j <= m; j++) {
            dp[0][j] = (long) j * costS2;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                        dp[i - 1][j] + costS1,
                        dp[i][j - 1] + costS2
                    );
                }
            }
        }

        return (int) dp[n][m];
    }
}
