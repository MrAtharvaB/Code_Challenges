class Solution {
    public int minTime(int[] ranks, int n) {
        int maxRank = 0;
        for (int r : ranks) maxRank = Math.max(maxRank, r);

        long high = (long) maxRank * n * (n + 1) / 2;
        long low = 0, ans = high;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (canMake(ranks, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    private boolean canMake(int[] ranks, int n, long time) {
        long donuts = 0;

        for (int r : ranks) {
            double val = 1.0 + (8.0 * time) / r;
            long k = (long) ((-1 + Math.sqrt(val)) / 2.0);

            donuts += k;
            if (donuts >= n) return true;
        }
        return donuts >= n;
    }
}
