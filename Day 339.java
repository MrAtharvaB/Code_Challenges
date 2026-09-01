class Solution {
    static final long MOD = 1000000007;

    public int palindromicStrings(int n, int k) {
        long ans = 0;

        for (int len = 1; len <= n; len++) {
            int half = len / 2;

            if (half > k) {
                continue;
            }

            long ways = 1;

            for (int i = 0; i < half; i++) {
                ways = (ways * (k - i)) % MOD;
            }

            if (len % 2 == 1) {
                ways = (ways * (k - half)) % MOD;
            }

            ans = (ans + ways) % MOD;
        }

        return (int) ans;
    }
}
