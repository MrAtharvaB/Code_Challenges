class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        
        long[] prefix = new long[n + 1];
        
        for(int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        
        for(int[] q : queries) {
            int l = q[0];
            int r = q[1];
            
            long sum = prefix[r + 1] - prefix[l];
            int len = r - l + 1;
            
            ans.add((int)(sum / len));
        }
        
        return ans;
    }
}
