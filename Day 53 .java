class Solution {
    public int LCIS(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] dp = new int[m];
        int result = 0;

        for (int i = 0; i < n; i++) {
            int currentMax = 0;
            for (int j = 0; j < m; j++) {
                if (a[i] == b[j]) {
                    if (currentMax + 1 > dp[j]) {
                        dp[j] = currentMax + 1;
                        if (dp[j] > result) result = dp[j];
                    }
                } else if (b[j] < a[i]) {
                    if (dp[j] > currentMax) currentMax = dp[j];
                }
            }
        }

        return result;
    }
}
