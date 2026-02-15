import java.util.*;

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        
        if (m == 0 || arr.size() == 0) 
            return 0;
            
        if (m > arr.size()) 
            return -1;

        Collections.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= arr.size() - m; i++) {
            int diff = arr.get(i + m - 1) - arr.get(i);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}
