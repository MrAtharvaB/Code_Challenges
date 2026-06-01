class Solution {
    public int findMaxProduct(int[] arr) {
        long MOD = 1000000007L;

        if (arr.length == 1) {
            return arr[0];
        }

        int negCount = 0, zeroCount = 0;
        int maxNeg = Integer.MIN_VALUE;
        long prod = 1;

        for (int x : arr) {
            if (x == 0) {
                zeroCount++;
                continue;
            }

            if (x < 0) {
                negCount++;
                maxNeg = Math.max(maxNeg, x);
            }

            prod = (prod * ((x % MOD + MOD) % MOD)) % MOD;
        }

        if (zeroCount == arr.length) {
            return 0;
        }

        if (negCount == 1 && negCount + zeroCount == arr.length) {
            return 0;
        }

        if ((negCount & 1) == 1) {
            long inv = modPow((maxNeg % MOD + MOD) % MOD, MOD - 2, MOD);
            prod = (prod * inv) % MOD;
        }

        return (int) prod;
    }

    private long modPow(long a, long b, long mod) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }

        return res;
    }
}
