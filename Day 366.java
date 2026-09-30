
class Solution {
    static final long MOD = 1000000007;

    public int ways(int x, int y) {
        int n = x + y;
        int r = Math.min(x, y);

        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2);

        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = (invFact[i] * i) % MOD;
        }

        return (int) ((fact[n] * invFact[r] % MOD)
                    * invFact[n - r] % MOD);
    }

    private long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return result;
    }
}
