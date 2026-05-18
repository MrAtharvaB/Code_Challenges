class Solution {
    public int maxSum(int n) {
        if (n == 0)
            return 0;

        return Math.max(n, maxSum(n / 2) + maxSum(n / 3) + maxSum(n / 4));
    }
}
