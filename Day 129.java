class Solution {
    public int maxCircularSum(int arr[]) {
        int n = arr.length;

        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        int minEndingHere = arr[0];
        int minSoFar = arr[0];

        int totalSum = arr[0];

        for (int i = 1; i < n; i++) {
            int x = arr[i];

            maxEndingHere = Math.max(x, maxEndingHere + x);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);

            minEndingHere = Math.min(x, minEndingHere + x);
            minSoFar = Math.min(minSoFar, minEndingHere);

            totalSum += x;
        }

        if (maxSoFar < 0) {
            return maxSoFar;
        }

        int maxWrap = totalSum - minSoFar;

        return Math.max(maxSoFar, maxWrap);
    }
}
