class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;

        int[] maxEnd = new int[n];
        maxEnd[0] = arr[0];

        for (int i = 1; i < n; i++) {
            maxEnd[i] = Math.max(arr[i], maxEnd[i - 1] + arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int ans = sum;

        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            ans = Math.max(ans, sum);
            ans = Math.max(ans, sum + maxEnd[i - k]);
        }

        return ans;
    }
}
