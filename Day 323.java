class Solution {
    public int minProd(int[] arr) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;

        for (int mask = 1; mask < (1 << n); mask++) {
            int product = 1;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    product *= arr[i];
                }
            }

            ans = Math.min(ans, product);
        }

        return ans;
    }
}
