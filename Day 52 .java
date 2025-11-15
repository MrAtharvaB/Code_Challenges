class Solution {
    public int minCutCost(int n, int[] cuts) {
        int m = cuts.length;

        int[] arr = new int[m + 2];
        for (int i = 0; i < m; i++) arr[i + 1] = cuts[i];
        arr[0] = 0;
        arr[m + 1] = n;
        Arrays.sort(arr);

        int[][] dp = new int[m + 2][m + 2];

        for (int len = 2; len < m + 2; len++) {
            for (int i = 0; i + len < m + 2; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            arr[j] - arr[i] +
                            dp[i][k] +
                            dp[k][j]);
                }
            }
        }

        return dp[0][m + 1];
    }
}
