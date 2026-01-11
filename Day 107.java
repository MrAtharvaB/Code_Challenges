class Solution {
    public String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                dp[i][0] = i;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (j == 0) {
                        dp[i][j] = i;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int minLen = Integer.MAX_VALUE;
        int start = -1;

        for (int i = 0; i < n; i++) {
            if (dp[i][m - 1] != -1) {
                int len = i - dp[i][m - 1] + 1;
                if (len < minLen) {
                    minLen = len;
                    start = dp[i][m - 1];
                }
            }
        }

        if (start == -1) return "";
        return s1.substring(start, start + minLen);
    }
}
