class Solution {
    
    public int minTime(int[] arr, int k) {
        int n = arr.length;
        
        long low = 0;
        long high = 0;
        
        for (int val : arr) {
            low = Math.max(low, val);
            high += val;
        }
        
        long ans = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (canPaint(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return (int) ans;
    }
    
    private boolean canPaint(int[] arr, int k, long maxTime) {
        int painters = 1;
        long currentSum = 0;
        
        for (int val : arr) {
            if (currentSum + val <= maxTime) {
                currentSum += val;
            } else {
                painters++;
                currentSum = val;
                
                if (painters > k) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
