class Solution {
    public int binarySearchable(int[] arr) {
        int n = arr.length;
        return solve(arr, 0, n - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int solve(int[] arr, int l, int r, int low, int high) {
        if (l > r) return 0;

        int mid = (l + r) / 2;
        int ans = 0;

        if (arr[mid] > low && arr[mid] < high) {
            ans = 1;
        }

        ans += solve(arr, l, mid - 1, low, Math.min(high, arr[mid]));
        ans += solve(arr, mid + 1, r, Math.max(low, arr[mid]), high);

        return ans;
    }
}
