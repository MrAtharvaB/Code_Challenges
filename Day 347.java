class Solution {
    public int findMax(int n) {
        int ans = n;
        int maxSum = digitSum(n);

        int p = 1;
        while (p <= n) {
            int x = (n / p) * p - 1;
            
            if (x >= 1 && digitSum(x) > maxSum) {
                maxSum = digitSum(x);
                ans = x;
            }
            
            p *= 10;
        }

        return ans;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
