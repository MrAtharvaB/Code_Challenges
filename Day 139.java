class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        
        long low = Integer.MAX_VALUE;
        long high = (long)1e14;
        
        for (int height : arr) {
            low = Math.min(low, height);
        }
        
        long ans = low;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (canAchieve(arr, k, w, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return (int) ans;
    }
    
    private boolean canAchieve(int[] arr, int k, int w, long target) {
        int n = arr.length;
        long[] diff = new long[n + 1];
        long waterUsed = 0;
        long currAdd = 0;
        
        for (int i = 0; i < n; i++) {
            currAdd += diff[i];
            
            long currentHeight = arr[i] + currAdd;
            
            if (currentHeight < target) {
                long need = target - currentHeight;
                waterUsed += need;
                
                if (waterUsed > k) return false;
                
                currAdd += need;
                
                if (i + w < n) {
                    diff[i + w] -= need;
                }
            }
        }
        
        return true;
    }
}
