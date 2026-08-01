class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        long[] diff = new long[n + 1];

        for (int i = 0; i < a.length; i++) {
            diff[a[i]] += k[i];
            if (b[i] + 1 < n) {
                diff[b[i] + 1] -= k[i];
            }
        }

        long curr = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {
            curr += diff[i];
            if (curr > max) {
                max = curr;
            }
        }

        return (int) max;
    }
}
