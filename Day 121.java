class Solution {
    int findWays(int n) {
        if ((n & 1) == 1) return 0;

        int k = n / 2;

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i <= k; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[k];
    }
}
