class Solution {
    static final int MOD = 1000000007;

    int distinctSubseq(String str) {
        int n = str.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) last[i] = -1;

        for (int i = 1; i <= n; i++) {
            char ch = str.charAt(i - 1);
            int idx = ch - 'a';
            dp[i] = (2L * dp[i - 1]) % MOD;
            if (last[idx] != -1) {
                dp[i] = (dp[i] - dp[last[idx] - 1] + MOD) % MOD;
            }
            last[idx] = i;
        }
        return (int) dp[n];
    }
}
