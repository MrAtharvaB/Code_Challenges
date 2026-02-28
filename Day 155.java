import java.util.*;

class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        
        int n = arr1.length;
        int m = arr2.length;
        
        int left = 0;
        int right = m - 1;
        
        int minDiff = Integer.MAX_VALUE;
        int res1 = 0, res2 = 0;
        
        while (left < n && right >= 0) {
            
            int sum = arr1[left] + arr2[right];
            int diff = Math.abs(sum - x);
            
            if (diff < minDiff) {
                minDiff = diff;
                res1 = arr1[left];
                res2 = arr2[right];
            }
            
            if (sum > x) {
                right--;
            } else {
                left++;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(res1);
        result.add(res2);
        
        return result;
    }
}
