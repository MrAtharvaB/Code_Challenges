class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        int NEG = -1000000;

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = NEG;
            }
        }

        dp[n][n] = 0;

        for (int i = 0; i < n; i++) {
            int[][] next = new int[n + 1][n + 1];

            for (int x = 0; x <= n; x++) {
                for (int y = 0; y <= n; y++) {
                    next[x][y] = NEG;
                }
            }

            for (int inc = 0; inc <= n; inc++) {
                for (int dec = 0; dec <= n; dec++) {
                    if (dp[inc][dec] == NEG) continue;

                    int current = dp[inc][dec];

                    next[inc][dec] = Math.max(next[inc][dec], current);

                    if (inc == n || arr[i] > arr[inc]) {
                        next[i][dec] = Math.max(next[i][dec], current + 1);
                    }

                    if (dec == n || arr[i] < arr[dec]) {
                        next[inc][i] = Math.max(next[inc][i], current + 1);
                    }
                }
            }

            dp = next;
        }

        int maxSelected = 0;

        for (int inc = 0; inc <= n; inc++) {
            for (int dec = 0; dec <= n; dec++) {
                maxSelected = Math.max(maxSelected, dp[inc][dec]);
            }
        }

        return n - maxSelected;
    }
}
