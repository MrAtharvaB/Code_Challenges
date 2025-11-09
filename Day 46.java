class Solution {
    private int n;
    private int[][] mat;
    private int[][][] dp;

    public int chocolatePickup(int[][] mat) {
        this.n = mat.length;
        this.mat = mat;
        this.dp = new int[n][n][n];
        for (int[][] arr2 : dp)
            for (int[] arr1 : arr2)
                Arrays.fill(arr1, Integer.MIN_VALUE);

        int ans = helper(0, 0, 0);
        return Math.max(ans, 0);
    }

    private int helper(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2; 

        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            mat[r1][c1] == -1 || mat[r2][c2] == -1)
            return Integer.MIN_VALUE;

        if (r1 == n - 1 && c1 == n - 1)
            return mat[r1][c1];

        if (dp[r1][c1][r2] != Integer.MIN_VALUE)
            return dp[r1][c1][r2];

        int res = mat[r1][c1];
        if (r1 != r2 || c1 != c2)
            res += mat[r2][c2];

        int temp = Math.max(
            Math.max(helper(r1 + 1, c1, r2 + 1), helper(r1, c1 + 1, r2)),
            Math.max(helper(r1 + 1, c1, r2), helper(r1, c1 + 1, r2 + 1))
        );

        res += temp == Integer.MIN_VALUE ? Integer.MIN_VALUE : temp;

        return dp[r1][c1][r2] = res;
    }
}
