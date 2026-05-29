class Solution {
    
    private int[][] dp;
    private String s;
    private int n;

    private int solve(int idx, int prevSum) {
        if (idx == n) return 1;

        if (dp[idx][prevSum] != -1)
            return dp[idx][prevSum];

        int ans = 0;
        int currSum = 0;

        for (int j = idx; j < n; j++) {
            currSum += s.charAt(j) - '0';

            if (currSum >= prevSum) {
                ans += solve(j + 1, currSum);
            }
        }

        return dp[idx][prevSum] = ans;
    }

    public int validGroups(String s) {
        this.s = s;
        this.n = s.length();

        dp = new int[n + 1][901];
        for (int i = 0; i <= n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return solve(0, 0);
    }
}
