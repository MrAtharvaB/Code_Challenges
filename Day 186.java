class Solution {
    public int maxProfit(int arr[], int k) {
        int n = arr.length;
        
        int hold = -arr[0];
        int cash = 0;
        
        for (int i = 1; i < n; i++) {
            int prevCash = cash;
            cash = Math.max(cash, hold + arr[i] - k);
            hold = Math.max(hold, prevCash - arr[i]);
        }
        
        return cash;
    }
}
