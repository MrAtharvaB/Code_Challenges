class Solution {
    public int bitonic(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] inc = new int[n];
        int[] dec = new int[n];

        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1])
                inc[i] = inc[i - 1] + 1;
            else
                inc[i] = 1;
        }

        dec[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1])
                dec[i] = dec[i + 1] + 1;
            else
                dec[i] = 1;
        }

        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, inc[i] + dec[i] - 1);
        }

        return ans;
    }
}
