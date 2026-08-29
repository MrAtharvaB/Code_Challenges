class Solution {
    public int countSubsequences(String s, int n) {
        final int MOD = 1000000007;
        long[] dp = new long[n];

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';
            long[] next = dp.clone();

            next[digit % n]++;

            for (int r = 0; r < n; r++) {
                int nr = (r * 10 + digit) % n;
                next[nr] = (next[nr] + dp[r]) % MOD;
            }

            dp = next;
        }

        return (int) dp[0];
    }
}
