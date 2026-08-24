class Solution {
    public int prefixStrings(int n) {
        long MOD = 1000000007L;

        long[] fact = new long[2 * n + 1];
        fact[0] = 1;

        for (int i = 1; i <= 2 * n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        long combination = fact[2 * n];

        combination = combination * power(fact[n], MOD - 2, MOD) % MOD;
        combination = combination * power(fact[n], MOD - 2, MOD) % MOD;

        return (int)(combination * power(n + 1, MOD - 2, MOD) % MOD);
    }

    private long power(long a, long b, long MOD) {
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
