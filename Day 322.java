class Solution {
    public int countWithout(int n, int d) {
        char[] a = String.valueOf(n).toCharArray();
        Integer[][][] dp = new Integer[a.length + 1][2][2];

        return dfs(0, 1, 0, a, d, dp) - 1;
    }

    private int dfs(int pos, int tight, int started,
                    char[] a, int d, Integer[][][] dp) {

        if (pos == a.length) {
            return 1;
        }

        if (dp[pos][tight][started] != null) {
            return dp[pos][tight][started];
        }

        int limit = (tight == 1) ? a[pos] - '0' : 9;
        int ans = 0;

        for (int digit = 0; digit <= limit; digit++) {
            int nextTight = (tight == 1 && digit == a[pos] - '0') ? 1 : 0;

            if (started == 0 && digit == 0) {
                ans += dfs(pos + 1, nextTight, 0, a, d, dp);
            } else if (digit != d) {
                ans += dfs(pos + 1, nextTight, 1, a, d, dp);
            }
        }

        return dp[pos][tight][started] = ans;
    }
}
