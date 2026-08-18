class Solution {
    public String compress(String s) {
        int n = s.length();

        int[] z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i < r)
                z[i] = Math.min(r - i, z[i - l]);

            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i]))
                z[i]++;

            if (i + z[i] > r) {
                l = i;
                r = i + z[i];
            }
        }

        int INF = 1_000_000_000;
        int[] dp = new int[n + 1];

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1 + dp[i + 1];

            if (i > 0 && 2 * i <= n && z[i] >= i) {
                dp[i] = Math.min(dp[i], 1 + dp[2 * i]);
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = 0;

        while (i < n) {
            if (i > 0 && 2 * i <= n &&
                z[i] >= i &&
                1 + dp[2 * i] == dp[i]) {

                ans.append('*');
                i *= 2;
            } else {
                ans.append(s.charAt(i));
                i++;
            }
        }

        return ans.toString();
    }
}
