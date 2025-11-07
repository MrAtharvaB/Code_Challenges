class Solution {
    public int maxProfit(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));
        int n = jobs.length;
        int[] dp = new int[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            int profit = jobs[i][2];
            int last = findLastNonOverlapping(jobs, i);
            if (last != -1) profit += dp[last];
            dp[i] = Math.max(dp[i - 1], profit);
        }

        return dp[n - 1];
    }

    private int findLastNonOverlapping(int[][] jobs, int i) {
        int low = 0, high = i - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid][1] <= jobs[i][0]) {
                if (mid + 1 < jobs.length && jobs[mid + 1][1] <= jobs[i][0])
                    low = mid + 1;
                else
                    return mid;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
