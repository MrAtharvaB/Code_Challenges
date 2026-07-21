class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int[] best = new int[26];

        for (int i = 0; i < 26; i++) best[i] = -1;

        int ans = -1;

        for (int i = n - 1; i >= 0; i--) {
            int ch = s.charAt(i) - 'a';

            if (ch < 25 && best[ch + 1] != -1) {
                dp[i] = best[ch + 1];
            } else {
                dp[i] = i;
            }

            best[ch] = Math.max(best[ch], dp[i]);

            if (ch == 0) { // 'a'
                ans = Math.max(ans, dp[i] - i);
            }
        }

        return ans;
    }
}
