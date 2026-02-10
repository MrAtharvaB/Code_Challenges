class Solution {
    public int kokoEat(int[] arr, int k) {
        int low = 1;
        int high = 0;

        for (int bananas : arr) {
            high = Math.max(high, bananas);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canFinish(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canFinish(int[] arr, int k, int s) {
        long hours = 0;

        for (int bananas : arr) {
            hours += (bananas + s - 1) / s;
            if (hours > k) return false;
        }

        return true;
    }
}
