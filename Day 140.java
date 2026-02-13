class Solution {
    
    private long sumOfDigits(long x) {
        long sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
    
    public int getCount(int n, int d) {
        long low = 1, high = n;
        long ans = -1;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (mid - sumOfDigits(mid) >= d) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        if (ans == -1) return 0;
        
        return (int)(n - ans + 1);
    }
}
