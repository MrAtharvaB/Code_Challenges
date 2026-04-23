class Solution {
    public boolean canSplit(int arr[]) {
        int totalSum = 0;
        
        for(int num : arr) {
            totalSum += num;
        }
        
        if(totalSum % 2 != 0) {
            return false;
        }
        
        int prefixSum = 0;
        
        for(int num : arr) {
            prefixSum += num;
            
            if(prefixSum == totalSum / 2) {
                return true;
            }
        }
        
        return false;
    }
}
