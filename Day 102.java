class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return 0;

        int currXor = 0;
        for (int i = 0; i < k; i++) {
            currXor ^= arr[i];
        }

        int maxXor = currXor;

        for (int i = k; i < n; i++) {
            currXor ^= arr[i];
            currXor ^= arr[i - k];
            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }
}
