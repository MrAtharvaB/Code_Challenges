class Solution {
    private static final int INF = (int)1e9;

    public int tsp(int[][] cost) {
        int n = cost.length;
        int maxMask = 1 << n;
        
        int[][] dp = new int[maxMask][n];
        
        for (int i = 0; i < maxMask; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(1, 0, cost, dp, n);
    }
    
    private int solve(int mask, int pos, int[][] cost, int[][] dp, int n) {
        if (mask == (1 << n) - 1) {
            return cost[pos][0];
        }
        
        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }
        
        int ans = INF;
        
        for (int next = 0; next < n; next++) {
            if ((mask & (1 << next)) == 0) {
                int newMask = mask | (1 << next);
                int candidate = cost[pos][next] + solve(newMask, next, cost, dp, n);
                ans = Math.min(ans, candidate);
            }
        }
        
        dp[mask][pos] = ans;
        return ans;
    }
}
