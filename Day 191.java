class Solution {
    public int totalWays(int[] arr, int target) {
        int sum = 0;
        for (int num : arr) sum += num;

        if ((sum + target) % 2 != 0 || Math.abs(target) > sum) {
            return 0;
        }

        int subsetSum = (sum + target) / 2;

        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;

        for (int num : arr) {
            for (int i = subsetSum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[subsetSum];
    }
}
