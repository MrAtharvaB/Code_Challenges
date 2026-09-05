class Solution {
    public int longestSubseq(int[] arr) {
        int[] dp = new int[1000002];
        int ans = 1;

        for (int x : arr) {
            int curr = 1;

            if (x > 1) {
                curr = Math.max(curr, dp[x - 1] + 1);
            }

            curr = Math.max(curr, dp[x + 1] + 1);

            dp[x] = Math.max(dp[x], curr);
            ans = Math.max(ans, dp[x]);
        }

        return ans;
    }
}
