class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return 0;

        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        long maxSum = windowSum;

        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        return (int) maxSum;
    }
}
