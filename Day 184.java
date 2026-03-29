class Solution {
    public int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        if (totalSum < diff || (totalSum + diff) % 2 != 0) {
            return 0;
        }

        int target = (totalSum + diff) / 2;

        return countSubsets(arr, target);
    }

    private int countSubsets(int[] arr, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }
}
