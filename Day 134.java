class Solution {
    int maxSum(int[] arr) {
        int n = arr.length;
        int arrSum = 0;
        int currVal = 0;

        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
            currVal += i * arr[i];
        }

        int maxVal = currVal;

        for (int i = 1; i < n; i++) {
            currVal = currVal + arrSum - n * arr[n - i];
            maxVal = Math.max(maxVal, currVal);
        }

        return maxVal;
    }
}
