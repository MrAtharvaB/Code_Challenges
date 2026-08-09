class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;
        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] next = new int[n];

            for (int j = 0; j < n; j++) {
                int max = 0;

                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        max = Math.max(max, dp[k]);
                    }
                }

                next[j] = mat[i][j] + max;
            }

            dp = next;
        }

        int ans = 0;
        for (int value : dp) {
            ans = Math.max(ans, value);
        }

        return ans;
    }
}
