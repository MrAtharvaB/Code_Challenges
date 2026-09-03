class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;

        if (n <= 1)
            return 0;

        long[][] dp = new long[n][2];

        dp[0][0] = 0;
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(
                dp[i - 1][0] + Math.abs(arr[i] - arr[i - 1]),
                dp[i - 1][1] + Math.abs(arr[i] - 1)
            );

            dp[i][1] = Math.max(
                dp[i - 1][0] + Math.abs(1 - arr[i - 1]),
                dp[i - 1][1]
            );
        }

        return (int) Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
