class Solution {
    static final long MOD = 1000000007L;

    public int computeValue(int n) {
        int m = 2 * n;

        long[] fact = new long[m + 1];
        long[] invFact = new long[m + 1];

        fact[0] = 1;
        for (int i = 1; i <= m; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[m] = modPow(fact[m], MOD - 2);

        for (int i = m - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }

        long ans = fact[m];
        ans = (ans * invFact[n]) % MOD;
        ans = (ans * invFact[n]) % MOD;

        return (int) ans;
    }

    private long modPow(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }
}
