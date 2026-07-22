import java.util.*;

class Solution {
    public int minDeletions(int[] arr) {
        ArrayList<Integer> lis = new ArrayList<>();
        
        for (int x : arr) {
            int idx = Collections.binarySearch(lis, x);
            if (idx < 0) idx = -idx - 1;
            
            if (idx == lis.size()) {
                lis.add(x);
            } else {
                lis.set(idx, x);
            }
        }
        
        return arr.length - lis.size();
    }
}
